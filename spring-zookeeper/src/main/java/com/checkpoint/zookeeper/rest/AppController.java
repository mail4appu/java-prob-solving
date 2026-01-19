package com.checkpoint.zookeeper.rest;

import com.checkpoint.zookeeper.model.AppProperties;
import com.checkpoint.zookeeper.model.CustomerDefinedConfiguration;
import com.checkpoint.zookeeper.model.CustomerRandomConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.async.AsyncCuratorFramework;
import org.apache.curator.x.async.modeled.ModeledFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

@RestController
public class AppController {
    Logger logger= LoggerFactory.getLogger(AppController.class);

    @Autowired
    ModeledFramework<CustomerDefinedConfiguration> modeledFramework;

    @Autowired
    AsyncCuratorFramework asyncCuratorFramework;

    @Autowired
    CuratorFramework curatorFramework;


    @Value("${spring.application.name}")
    private String appName;


    @Autowired
    AppProperties appProperties;


    @Autowired
    CustomerDefinedConfiguration customerDefinedConfiguration;

    @Autowired
    CustomerRandomConfiguration customerRandomConfiguration;

    @Autowired
    ModeledFramework<Map> modeledFrameworkRandom;

    @RequestMapping(value = "/encryption", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> getEncryption() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(mapper.writeValueAsString(appProperties.getAlgorithm()));
            System.out.println(jsonNode.toPrettyString());
            return ResponseEntity.ok(jsonNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }


    @RequestMapping(value = "/location", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > createLocation(@RequestBody JsonNode jsonNode) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String location = jsonNode.get("location").asText();
            curatorFramework.create().forPath("/config/location", location.getBytes());
            return ResponseEntity.ok("created location");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }



    /** ====================Application Without Profiles ========================**/

    @RequestMapping(value = "/configuration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addAppConfigurationInProperties(@RequestBody CustomerDefinedConfiguration customerDefinedConfiguration) {

        asyncCuratorFramework.create().forPath("/config");
        asyncCuratorFramework.create().forPath("/config/"+ appName);
        asyncCuratorFramework.create().forPath("/config/"+ appName + "/algorithm", customerDefinedConfiguration.getAlgorithm().getBytes());
        asyncCuratorFramework.create().forPath("/config/"+ appName + "/secretKey", customerDefinedConfiguration.getSecretKey().getBytes());
        asyncCuratorFramework.create().forPath("/config/"+ appName + "/maxAllowedClients", customerDefinedConfiguration.getMaxAllowedClients().getBytes());
        asyncCuratorFramework.create().forPath("/config/" + appName + "/retailerUrl", customerDefinedConfiguration.getRetailerUrl().getBytes());
        return ResponseEntity.ok("Created configuration for application " + appName );

    }

    @RequestMapping(value = "/configuration", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAppConfigurationInProperties( @RequestBody CustomerDefinedConfiguration customerDefinedConfiguration) {

        asyncCuratorFramework.setData().forPath("/config/" + appName + "/algorithm", customerDefinedConfiguration.getAlgorithm().getBytes());
        asyncCuratorFramework.setData().forPath("/config/"+ appName + "/secretKey", customerDefinedConfiguration.getSecretKey().getBytes());
        asyncCuratorFramework.setData().forPath("/config/"+ appName + "/maxAllowedClients", customerDefinedConfiguration.getMaxAllowedClients().getBytes());
        asyncCuratorFramework.setData().forPath("/config/"+ appName + "/retailerUrl", customerDefinedConfiguration.getRetailerUrl().getBytes());
        return ResponseEntity.ok("Updated configuration for application" + appName);

    }


    @RequestMapping(value = "/configuration", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDefinedConfiguration getAppConfigurationFromProperties() throws Exception {
        return customerDefinedConfiguration;

    }




    /** ==============RANDOM CONFIGURATION  WITHOUT PROFILES============================= **/

    @RequestMapping(value = "/configuration/random", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > createAppRandomConfig(@RequestBody JsonNode jsonNode) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> properties = mapper.convertValue(jsonNode, new TypeReference<Map<String, String>>() {
        });
        customerRandomConfiguration.getAppConfiguration().putAll(properties);
        //curatorFramework.create().forPath("/config/" + appName , SerializationUtils.serialize(customerRandomConfiguration.getConfiguration()));
        modeledFrameworkRandom.set(customerRandomConfiguration.getAppConfiguration());
        return ResponseEntity.ok("created random configuration  for "+ appName);

    }

    @RequestMapping(value = "/configuration/random/json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > createAppRandomConfigAsJson(@RequestBody JsonNode jsonNode) throws Exception {
          createConfiguration(jsonNode);
        return ResponseEntity.ok("created random configuration  for "+ appName);

    }



    @RequestMapping(value = "/configuration/random", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > updateAppRandomConfig(@RequestBody JsonNode jsonNode) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> properties = mapper.convertValue(jsonNode, new TypeReference<Map<String, String>>() {
        });
        customerRandomConfiguration.getAppConfiguration().putAll(properties);
        asyncCuratorFramework.setData().forPath("/config/" + appName , SerializationUtils.serialize(customerRandomConfiguration.getAppConfiguration()));
        return ResponseEntity.ok("created random configuration for "+ appName);

    }



    @RequestMapping(value = "/configuration/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAppProperties() throws Exception {
        return ResponseEntity.ok(customerRandomConfiguration.getAppConfiguration());

    }

    /** ==============RANDOM CONFIGURATION  WITH PROFILES============================= **/

    @RequestMapping(value = "/configuration/random/{customerName}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > createRandomConfig(@RequestBody JsonNode jsonNode, @PathVariable(value = "customerName") String customerName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> properties = mapper.convertValue(jsonNode, new TypeReference<Map<String, String>>() {
        });
        customerRandomConfiguration.getAppConfiguration().putAll(properties);
        asyncCuratorFramework.create().forPath("/config/" + appName + "::" + customerName , SerializationUtils.serialize(customerRandomConfiguration.getAppConfiguration()));
        return ResponseEntity.ok("created properties for "+ customerName);

    }


    @RequestMapping(value = "/configuration/random/{customerName}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > updateRandomConfig(@RequestBody JsonNode jsonNode, @PathVariable(value = "customerName") String customerName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> properties = mapper.convertValue(jsonNode, new TypeReference<Map<String, String>>() {
        });
        customerRandomConfiguration.getAppConfiguration().putAll(properties);
        asyncCuratorFramework.setData().forPath("/config/" + appName + "::" + customerName , SerializationUtils.serialize(customerRandomConfiguration.getAppConfiguration()));
        return ResponseEntity.ok("created properties for "+ customerName);

    }



    @RequestMapping(value = "/configuration/random/{customerName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String> > getProperties(@PathVariable(value = "customerName") String customerName) throws Exception {
        return ResponseEntity.ok(customerRandomConfiguration.getAppConfiguration());

    }





    /** ===================== Defined Configuration =========================== **/

    @RequestMapping(value = "/configuration/{customerId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addConfigurationInProperties(@PathVariable(value = "customerId") String customerName, @RequestBody CustomerDefinedConfiguration customerDefinedConfiguration) {

        asyncCuratorFramework.create().forPath("/config");
        asyncCuratorFramework.create().forPath("/config/" + appName + "::" + customerName);
        asyncCuratorFramework.create().forPath("/config/" + appName + "::" + customerName + "/algorithm", customerDefinedConfiguration.getAlgorithm().getBytes());
        asyncCuratorFramework.create().forPath("/config/" + appName + "::" + customerName + "/secretKey", customerDefinedConfiguration.getSecretKey().getBytes());
        asyncCuratorFramework.create().forPath("/config/" + appName + "::" + customerName + "/maxAllowedClients", customerDefinedConfiguration.getMaxAllowedClients().getBytes());
        asyncCuratorFramework.create().forPath("/config/" + appName + "::" + customerName + "/retailerUrl", customerDefinedConfiguration.getRetailerUrl().getBytes());
        return ResponseEntity.ok("Created configuration for " + customerName + " in properties ");

    }


    @RequestMapping(value = "/configuration/{customerId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateConfigurationInProperties(@PathVariable(value = "customerId") String customerName, @RequestBody CustomerDefinedConfiguration customerDefinedConfiguration) {

        asyncCuratorFramework.setData().forPath("/config/" + appName + "::" + customerName + "/algorithm", customerDefinedConfiguration.getAlgorithm().getBytes());
        asyncCuratorFramework.setData().forPath("/config/" + appName + "::" + customerName + "/secretKey", customerDefinedConfiguration.getSecretKey().getBytes());
        asyncCuratorFramework.setData().forPath("/config/" + appName + "::" + customerName + "/maxAllowedClients", customerDefinedConfiguration.getMaxAllowedClients().getBytes());
        asyncCuratorFramework.setData().forPath("/config/" + appName + "::" + customerName + "/retailerUrl", customerDefinedConfiguration.getRetailerUrl().getBytes());
        return ResponseEntity.ok("Updated configuration for " + customerName + "  in properties");

    }


    @RequestMapping(value = "/configuration/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDefinedConfiguration getConfigurationFromProperties(@PathVariable(value = "customerId") String customerName) throws Exception {
        return customerDefinedConfiguration;

    }


    /** ========================= Configuration as model ==================== **/
    @RequestMapping(value = "/configuration/v2/{customerId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addConfigurationAsModel(@PathVariable(value = "customerId") String customerName, @RequestBody CustomerDefinedConfiguration customerDefinedConfiguration) {
        modeledFramework.set(customerDefinedConfiguration);
        return ResponseEntity.ok("Created configuration for " + customerName + " as object ");

    }


    @RequestMapping(value = "/configuration/v2/{customerId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDefinedConfiguration getConfiguration() {
        CustomerDefinedConfiguration prepared = new CustomerDefinedConfiguration();
        return null;


    }




    @RequestMapping(value = "/dump", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> dumpDataIntoZookeeper() throws Exception {
        curatorFramework.create().forPath("/config/data");
        for(int i=0;i<100000;i++){
            curatorFramework.create().forPath("/config/data/keys-"+i, ("value-"+i).getBytes());
        }
        return  new ResponseEntity<Void>(HttpStatus.CREATED);
    }




    @RequestMapping(value = "/location", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > updateLocation(@RequestBody JsonNode jsonNode) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String location = jsonNode.get("location").asText();
            curatorFramework.setData().forPath("/config/location", location.getBytes());
            return ResponseEntity.ok("Updated location");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }


    @RequestMapping(value = "/location", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > getLocation() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            curatorFramework.sync();
            byte[] bytes = curatorFramework.getData().forPath("/config/location");
            return ResponseEntity.ok(new String(bytes, StandardCharsets.UTF_8));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }


    private void createConfiguration(JsonNode root) throws Exception {
        if(root.isObject()){
            Iterator<String> fieldNames = root.fieldNames();

            while(fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode fieldValue = root.get(fieldName);
                createConfiguration(fieldValue);
                curatorFramework.create().forPath("/config/"+appName+"/"+fieldName, root.asText().getBytes());
            }
        } else if(root.isArray()){
            ArrayNode arrayNode = (ArrayNode) root;
            for(int i = 0; i < arrayNode.size(); i++) {
                JsonNode arrayElement = arrayNode.get(i);
                createConfiguration(arrayElement);
            }
        } else {
            // JsonNode root represents a single value field - do something with it.



        }
    }


}
