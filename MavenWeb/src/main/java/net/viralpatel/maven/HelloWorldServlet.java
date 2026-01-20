package net.viralpatel.maven;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * URLEnocder.encode(url, "UTF-8") is different from response.encodeRedirectUrl()
 *
 */
public class HelloWorldServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1031422249396784970L;

	private SimpleDateFormat datePattern=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



	private static final Logger audit_logger=LoggerFactory.getLogger(HelloWorldServlet.class);

	private static final Logger normalLog= LoggerFactory.getLogger("noraml_logger");



	/*@PreDestroy
	public void flushLogs() {
		normalLog.info("Shutdown logger context.");
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		loggerContext.stop();
	}
*/
	UriInfo uriInfo=null;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		audit_logger.info(datePattern.format(new Date())+ " , hello world ,  servlet audit log|PHNhbWxwOlJlc3BvbnNlIHhtbG5zOnNhbWxwPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6\n" +
				"cHJvdG9jb2wiIERlc3RpbmF0aW9uPSJodHRwOi8vbG9jYWxob3N0OjgwODAvbG9naW4td2ViYXBw\n" +
				"L3NhbWwvU1NPIiBJRD0iczJjOGIyMDZjMWVmMzlkNmY4NDRiNzU3M2NkZWViNjc2ODI3MWJkYmUz\n" +
				"IiBJblJlc3BvbnNlVG89ImExMWQxOTEzOGFjMTg1MmMxNjI3NzZmYzloMWJmOGciIElzc3VlSW5z\n" +
				"dGFudD0iMjAxNy0wNS0wOVQwNTo0MTo0MVoiIFZlcnNpb249IjIuMCI+PHNhbWw6SXNzdWVyIHht\n" +
				"bG5zOnNhbWw9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphc3NlcnRpb24iPmh0dHBzOi8v\n" +
				"aW1zLXNxZS5idHNlYy5kZXYuc2NobmVpZGVyLWVsZWN0cmljLmNvbTo0NDMvb3BlbnNzbzwvc2Ft\n" +
				"bDpJc3N1ZXI+PGRzOlNpZ25hdHVyZSB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8w\n" +
				"OS94bWxkc2lnIyI+CjxkczpTaWduZWRJbmZvPgo8ZHM6Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBB\n" +
				"bGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyIvPgo8ZHM6\n" +
				"U2lnbmF0dXJlTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxk\n" +
				"c2lnI3JzYS1zaGExIi8+CjxkczpSZWZlcmVuY2UgVVJJPSIjczJjOGIyMDZjMWVmMzlkNmY4NDRi\n" +
				"NzU3M2NkZWViNjc2ODI3MWJkYmUzIj4KPGRzOlRyYW5zZm9ybXM+CjxkczpUcmFuc2Zvcm0gQWxn\n" +
				"b3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25h\n" +
				"dHVyZSIvPgo8ZHM6VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8x\n" +
				"MC94bWwtZXhjLWMxNG4jIi8+CjwvZHM6VHJhbnNmb3Jtcz4KPGRzOkRpZ2VzdE1ldGhvZCBBbGdv\n" +
				"cml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNzaGExIi8+CjxkczpEaWdl\n" +
				"c3RWYWx1ZT5kaWRlTmMvcjd4YllGQzBMTCtrNTdXUWgybjg9PC9kczpEaWdlc3RWYWx1ZT4KPC9k\n" +
				"czpSZWZlcmVuY2U+CjwvZHM6U2lnbmVkSW5mbz4KPGRzOlNpZ25hdHVyZVZhbHVlPgpHOW0yYkhP\n" +
				"YnJ1VVFZVTRVSnhObHRLWkhnT1BlTEtRSThkL1ErTEVLRnZ6WTFiNGxUdnFic3lMenY1Yjd0blRL\n" +
				"K1ZhOXRVcmFua01iCnE4VGRGcHc2d0trWmIvaDVHcTdHM1pSWGxpN00xcGRKcDNGUWtKczVrQUZX\n" +
				"d2JSNXFqN3hYT0ZvNnhvYWp2VWRiZ3kxbjd0M3VSY0cKRE8rais1ZFdpMkxjK3BEZWljOGhoNjVn\n" +
				"c1NXd1gyajNkWGJ6Q2VYYVdIMVB1MGtxanJLU0VUQnJlZGozNjFsU3F2NTVyb1RTbUlYKwpuakwz\n" +
				"enIvNm5kMFFaQ25pTGlsOFU0dC9DRW45ZjFxVHFiQjJJcGpIR3JjeDNYUjZ3NCtReDE5Q2Q4UWNU\n" +
				"RUFud09SZmYwdElMWndoCnNxSFhvRG1VaTYvNXN3bUkxbjBVbUV4OXA5cFFyQWVadkZYc3N3PT0K\n" +
				"PC9kczpTaWduYXR1cmVWYWx1ZT4KPGRzOktleUluZm8+CjxkczpYNTA5RGF0YT4KPGRzOlg1MDlD\n" +
				"ZXJ0aWZpY2F0ZT4KTUlJRGVUQ0NBbUdnQXdJQkFnSUVET3VEUERBTkJna3Foa2lHOXcwQkFRc0ZB\n" +
				"REJ0TVFzd0NRWURWUVFHRXdKR1VqRU9NQXdHQTFVRQpDQk1GU1hObGNtVXhFVEFQQmdOVkJBY1RD\n" +
				"RWR5Wlc1dllteGxNUnN3R1FZRFZRUUtFeEpUWTJodVpXbGtaWEl0Uld4bFkzUnlhV014CkREQUtC\n" +
				"Z05WQkFzVEEybHRjekVRTUE0R0ExVUVBeE1IYVcxekxYTnhaVEFlRncweE5qQTNNRFF4TkRBeU1U\n" +
				"QmFGdzB4T0RBNU1qSXgKTkRBeU1UQmFNRzB4Q3pBSkJnTlZCQVlUQWtaU01RNHdEQVlEVlFRSUV3\n" +
				"VkpjMlZ5WlRFUk1BOEdBMVVFQnhNSVIzSmxibTlpYkdVeApHekFaQmdOVkJBb1RFbE5qYUc1bGFX\n" +
				"UmxjaTFGYkdWamRISnBZekVNTUFvR0ExVUVDeE1EYVcxek1SQXdEZ1lEVlFRREV3ZHBiWE10CmMz\n" +
				"RmxNSUlCSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQVE4QU1JSUJDZ0tDQVFFQWpVYmxKTmVLTmtP\n" +
				"QzRpbkpLT3kzbDQ2Y0Mrdi8KdWlEZCtUMm90bm5SQmVYVDlmMzJEaWFaVVRVUmt3S3g2WExYR3VU\n" +
				"WUVxRnZtRkdJVlY5UEQ5RE5kL1VPNzd2SE5kN2VpV0RWS1IvTgoxNkFqVXJyUGdHU09lUGx6ek9S\n" +
				"dXVPRjdac0pYVXgwdzZ5dUloVGJqUENrdWMrSmUzR3ZyTC9IMkE3MUl0ZjJvYjVtcHlRb2J5MzV2\n" +
				"CkwvWUZ5WEZPeTVxVng2Nnd5T1JQemV6R1lSSjJJYjRXVGpBTnZQSmtuNmlLM1c2MXJGUUhMMlE3\n" +
				"Wm1Kb3JYL3VIOU81Qk5ha0lLajUKcDJnUG9PWE44UnQyTjhJSDAwQ0pSY1dadE9BYnA3dDBzWUll\n" +
				"MDRPTGFuQWRIQ0hnWHVlL2RhQ01RU0dLbHNjSUlUYTB0dHpEeEtwTQpvakZrN04wQWxRSURBUUFC\n" +
				"b3lFd0h6QWRCZ05WSFE0RUZnUVVYMENFaWY4Nzlzc2R1Tkh6ZmVtMDJJQ0ZOeTR3RFFZSktvWklo\n" +
				"dmNOCkFRRUxCUUFEZ2dFQkFCSDVmaEp1dXVqandNeGQ4UkNqMkFaVWp6dXRPOVc4U1AzMHd0UlhH\n" +
				"bldrYXcxZk9HK2tDMG9GbGF2cUJBUTMKUUltSTRWNWtackk3bXg1WjBMYjF4Wjg0UlNDSWxKUmpR\n" +
				"dEV2ckJWMlVXanM4TUlYMXJLUWV2Nmo3UlpTcEp4TzMxbUlQYkJtRDBZZApYS29jb3RPeDVOYy92\n" +
				"VzRRR01DZ3JKTmxjbHlRbDhZekUzUVl2S3JsSnJuWm1kTVpkQkU4SklwaEtLOXo3WFZNY1pGcGMw\n" +
				"MStKUTFoCm1HV1UvQ0JvTk0rR0dMWmY5bTdDQ0xYamhhYUR6Y1hFTUdsVDdyZjhqcnVoa3lUcVNL\n" +
				"NDlzKzBjZmtTTWZyWXNNbHlMVjJ0ZVV6bDkKdDYrVGI4VEhYMWFxejBuVThhdk5aeDFiRkxzZU8z\n" +
				"UWJURzVKeFZXZFltK3dlQ0hXQ0lvPQo8L2RzOlg1MDlDZXJ0aWZpY2F0ZT4KPC9kczpYNTA5RGF0\n" +
				"YT4KPC9kczpLZXlJbmZvPgo8L2RzOlNpZ25hdHVyZT48c2FtbHA6U3RhdHVzIHhtbG5zOnNhbWxw\n" +
				"PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6cHJvdG9jb2wiPgo8c2FtbHA6U3RhdHVzQ29k\n" +
				"ZSBWYWx1ZT0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnN0YXR1czpTdWNjZXNzIiB4bWxu\n" +
				"czpzYW1scD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnByb3RvY29sIj4KPC9zYW1scDpT\n" +
				"dGF0dXNDb2RlPgo8L3NhbWxwOlN0YXR1cz48c2FtbDpBc3NlcnRpb24geG1sbnM6c2FtbD0idXJu\n" +
				"Om9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiIgSUQ9InMyODZiNWNhNWZiYTgyMTIz\n" +
				"NmQ4ZjQxNTFmYjI2MWJiZmRhMDdjMzdjZCIgSXNzdWVJbnN0YW50PSIyMDE3LTA1LTA5VDA1OjQx\n" +
				"OjQxWiIgVmVyc2lvbj0iMi4wIj4KPHNhbWw6SXNzdWVyPmh0dHBzOi8vaW1zLXNxZS5idHNlYy5k\n" +
				"ZXYuc2NobmVpZGVyLWVsZWN0cmljLmNvbTo0NDMvb3BlbnNzbzwvc2FtbDpJc3N1ZXI+PGRzOlNp\n" +
				"Z25hdHVyZSB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+Cjxk\n" +
				"czpTaWduZWRJbmZvPgo8ZHM6Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6\n" +
				"Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyIvPgo8ZHM6U2lnbmF0dXJlTWV0aG9k\n" +
				"IEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3JzYS1zaGExIi8+\n" +
				"CjxkczpSZWZlcmVuY2UgVVJJPSIjczI4NmI1Y2E1ZmJhODIxMjM2ZDhmNDE1MWZiMjYxYmJmZGEw\n" +
				"N2MzN2NkIj4KPGRzOlRyYW5zZm9ybXM+CjxkczpUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8v\n" +
				"d3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25hdHVyZSIvPgo8ZHM6VHJh\n" +
				"bnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4j\n" +
				"Ii8+CjwvZHM6VHJhbnNmb3Jtcz4KPGRzOkRpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93\n" +
				"d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNzaGExIi8+CjxkczpEaWdlc3RWYWx1ZT43QnhPNjJ5\n" +
				"SFFVOWxPM3UwWTNRMkJ4cko1UmM9PC9kczpEaWdlc3RWYWx1ZT4KPC9kczpSZWZlcmVuY2U+Cjwv\n" +
				"ZHM6U2lnbmVkSW5mbz4KPGRzOlNpZ25hdHVyZVZhbHVlPgpTeTVUM1I5dncwY0J1TlBRbDVvekhC\n" +
				"TTVFcVFENUFDc2lmT09UR2YwUlVKUlhyTmxvei9qVW52Z3ZndERUcEdIRnM4K0NwS2xzS2dJCklv\n" +
				"cFFHRERHS2VlUktTb0tGVklBSGx6M0lwbzExcmlsVWxvcEprb2FyL3huQ1JTYUxrSjd3QVV1QUFX\n" +
				"UmM4TXZXK25ScDhDSGpCQXoKYy9XMStOWE9mRHRaMzRzaWh2Rks2MW9ueDFJT1lVMHAxZU5pZytH\n" +
				"NWRSU3p1Z2lnUkM2TnpnU1RrYTg0M1VpYnl0dS8rVGoxa2hPRgpNeTJucVZqcWxYZWdmTW1rTk00\n" +
				"QXRKcUNZUkZYUGdpVTBKQmV2WWZhT0dPMU56YkRlMEZkWUVoSTlsNWlCY0NyUWJZc2MrMlIrZlRP\n" +
				"CkNSeEkxWHoxQ1BCTmpMRWJXd2VTRldDbjQ0N3lXcnpQZytjcDl3PT0KPC9kczpTaWduYXR1cmVW\n" +
				"YWx1ZT4KPGRzOktleUluZm8+CjxkczpYNTA5RGF0YT4KPGRzOlg1MDlDZXJ0aWZpY2F0ZT4KTUlJ\n" +
				"RGVUQ0NBbUdnQXdJQkFnSUVET3VEUERBTkJna3Foa2lHOXcwQkFRc0ZBREJ0TVFzd0NRWURWUVFH\n" +
				"RXdKR1VqRU9NQXdHQTFVRQpDQk1GU1hObGNtVXhFVEFQQmdOVkJBY1RDRWR5Wlc1dllteGxNUnN3\n" +
				"R1FZRFZRUUtFeEpUWTJodVpXbGtaWEl0Uld4bFkzUnlhV014CkREQUtCZ05WQkFzVEEybHRjekVR\n" +
				"TUE0R0ExVUVBeE1IYVcxekxYTnhaVEFlRncweE5qQTNNRFF4TkRBeU1UQmFGdzB4T0RBNU1qSXgK\n" +
				"TkRBeU1UQmFNRzB4Q3pBSkJnTlZCQVlUQWtaU01RNHdEQVlEVlFRSUV3VkpjMlZ5WlRFUk1BOEdB\n" +
				"MVVFQnhNSVIzSmxibTlpYkdVeApHekFaQmdOVkJBb1RFbE5qYUc1bGFXUmxjaTFGYkdWamRISnBZ\n" +
				"ekVNTUFvR0ExVUVDeE1EYVcxek1SQXdEZ1lEVlFRREV3ZHBiWE10CmMzRmxNSUlCSWpBTkJna3Fo\n" +
				"a2lHOXcwQkFRRUZBQU9DQVE4QU1JSUJDZ0tDQVFFQWpVYmxKTmVLTmtPQzRpbkpLT3kzbDQ2Y0Mr\n" +
				"di8KdWlEZCtUMm90bm5SQmVYVDlmMzJEaWFaVVRVUmt3S3g2WExYR3VUWUVxRnZtRkdJVlY5UEQ5\n" +
				"RE5kL1VPNzd2SE5kN2VpV0RWS1IvTgoxNkFqVXJyUGdHU09lUGx6ek9SdXVPRjdac0pYVXgwdzZ5\n" +
				"dUloVGJqUENrdWMrSmUzR3ZyTC9IMkE3MUl0ZjJvYjVtcHlRb2J5MzV2CkwvWUZ5WEZPeTVxVng2\n" +
				"Nnd5T1JQemV6R1lSSjJJYjRXVGpBTnZQSmtuNmlLM1c2MXJGUUhMMlE3Wm1Kb3JYL3VIOU81Qk5h\n" +
				"a0lLajUKcDJnUG9PWE44UnQyTjhJSDAwQ0pSY1dadE9BYnA3dDBzWUllMDRPTGFuQWRIQ0hnWHVl\n" +
				"L2RhQ01RU0dLbHNjSUlUYTB0dHpEeEtwTQpvakZrN04wQWxRSURBUUFCb3lFd0h6QWRCZ05WSFE0\n" +
				"RUZnUVVYMENFaWY4Nzlzc2R1Tkh6ZmVtMDJJQ0ZOeTR3RFFZSktvWklodmNOCkFRRUxCUUFEZ2dF\n" +
				"QkFCSDVmaEp1dXVqandNeGQ4UkNqMkFaVWp6dXRPOVc4U1AzMHd0UlhHbldrYXcxZk9HK2tDMG9G\n" +
				"bGF2cUJBUTMKUUltSTRWNWtackk3bXg1WjBMYjF4Wjg0UlNDSWxKUmpRdEV2ckJWMlVXanM4TUlY\n" +
				"MXJLUWV2Nmo3UlpTcEp4TzMxbUlQYkJtRDBZZApYS29jb3RPeDVOYy92VzRRR01DZ3JKTmxjbHlR\n" +
				"bDhZekUzUVl2S3JsSnJuWm1kTVpkQkU4SklwaEtLOXo3WFZNY1pGcGMwMStKUTFoCm1HV1UvQ0Jv\n" +
				"Tk0rR0dMWmY5bTdDQ0xYamhhYUR6Y1hFTUdsVDdyZjhqcnVoa3lUcVNLNDlzKzBjZmtTTWZyWXNN\n" +
				"bHlMVjJ0ZVV6bDkKdDYrVGI4VEhYMWFxejBuVThhdk5aeDFiRkxzZU8zUWJURzVKeFZXZFltK3dl\n" +
				"Q0hXQ0lvPQo8L2RzOlg1MDlDZXJ0aWZpY2F0ZT4KPC9kczpYNTA5RGF0YT4KPC9kczpLZXlJbmZv\n" +
				"Pgo8L2RzOlNpZ25hdHVyZT48c2FtbDpTdWJqZWN0Pgo8c2FtbDpOYW1lSUQgRm9ybWF0PSJ1cm46\n" +
				"b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6bmFtZWlkLWZvcm1hdDp0cmFuc2llbnQiIE5hbWVRdWFs\n" +
				"aWZpZXI9Imh0dHBzOi8vaW1zLXNxZS5idHNlYy5kZXYuc2NobmVpZGVyLWVsZWN0cmljLmNvbTo0\n" +
				"NDMvb3BlbnNzbyIgU1BOYW1lUXVhbGlmaWVyPSJEQ0VTTG9naW4tREVWIj5xUWJhdnJhTSs5aGdz\n" +
				"VW45Zmtnb0lqc3BTcHVnPC9zYW1sOk5hbWVJRD48c2FtbDpTdWJqZWN0Q29uZmlybWF0aW9uIE1l\n" +
				"dGhvZD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmNtOmJlYXJlciI+CjxzYW1sOlN1Ympl\n" +
				"Y3RDb25maXJtYXRpb25EYXRhIEluUmVzcG9uc2VUbz0iYTExZDE5MTM4YWMxODUyYzE2Mjc3NmZj\n" +
				"OWgxYmY4ZyIgTm90T25PckFmdGVyPSIyMDE3LTA1LTA5VDA1OjUxOjQxWiIgUmVjaXBpZW50PSJo\n" +
				"dHRwOi8vbG9jYWxob3N0OjgwODAvbG9naW4td2ViYXBwL3NhbWwvU1NPIi8+PC9zYW1sOlN1Ympl\n" +
				"Y3RDb25maXJtYXRpb24+Cjwvc2FtbDpTdWJqZWN0PjxzYW1sOkNvbmRpdGlvbnMgTm90QmVmb3Jl\n" +
				"PSIyMDE3LTA1LTA5VDA1OjMxOjQxWiIgTm90T25PckFmdGVyPSIyMDE3LTA1LTA5VDA1OjUxOjQx\n" +
				"WiI+CjxzYW1sOkF1ZGllbmNlUmVzdHJpY3Rpb24+CjxzYW1sOkF1ZGllbmNlPkRDRVNMb2dpbi1E\n" +
				"RVY8L3NhbWw6QXVkaWVuY2U+Cjwvc2FtbDpBdWRpZW5jZVJlc3RyaWN0aW9uPgo8L3NhbWw6Q29u\n" +
				"ZGl0aW9ucz4KPHNhbWw6QXV0aG5TdGF0ZW1lbnQgQXV0aG5JbnN0YW50PSIyMDE3LTA1LTA5VDA1\n" +
				"OjQxOjQxWiIgU2Vzc2lvbkluZGV4PSJzMjQ0ODJjNWYzNjliOGI5MGViN2U1NWU5N2E5NDcyZmI5\n" +
				"OTg0MzYyMDEiPjxzYW1sOkF1dGhuQ29udGV4dD48c2FtbDpBdXRobkNvbnRleHRDbGFzc1JlZj51\n" +
				"cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YWM6Y2xhc3NlczpQYXNzd29yZFByb3RlY3RlZFRy\n" +
				"YW5zcG9ydDwvc2FtbDpBdXRobkNvbnRleHRDbGFzc1JlZj48L3NhbWw6QXV0aG5Db250ZXh0Pjwv\n" +
				"c2FtbDpBdXRoblN0YXRlbWVudD48c2FtbDpBdHRyaWJ1dGVTdGF0ZW1lbnQ+PHNhbWw6QXR0cmli\n" +
				"dXRlIE5hbWU9InByZWZlcnJlZExhbmd1YWdlIj48c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4bWxuczp4\n" +
				"cz0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEiIHhtbG5zOnhzaT0iaHR0cDovL3d3\n" +
				"dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTp0eXBlPSJ4czpzdHJpbmciPmVu\n" +
				"PC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PHNhbWw6QXR0cmlidXRlIE5h\n" +
				"bWU9InRlbGVwaG9uZU51bWJlciI+PHNhbWw6QXR0cmlidXRlVmFsdWUgeG1sbnM6eHM9Imh0dHA6\n" +
				"Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hIiB4bWxuczp4c2k9Imh0dHA6Ly93d3cudzMub3Jn\n" +
				"LzIwMDEvWE1MU2NoZW1hLWluc3RhbmNlIiB4c2k6dHlwZT0ieHM6c3RyaW5nIj4wODAgMTIzNDU2\n" +
				"Nzg8L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUg\n" +
				"TmFtZT0icGFydG5lckFjY291bnRJZCI+PHNhbWw6QXR0cmlidXRlVmFsdWUgeG1sbnM6eHM9Imh0\n" +
				"dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hIiB4bWxuczp4c2k9Imh0dHA6Ly93d3cudzMu\n" +
				"b3JnLzIwMDEvWE1MU2NoZW1hLWluc3RhbmNlIiB4c2k6dHlwZT0ieHM6c3RyaW5nIj5kZW1vPC9z\n" +
				"YW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PHNhbWw6QXR0cmlidXRlIE5hbWU9\n" +
				"InNvdXJjZVN5c3RlbUlkIj48c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4bWxuczp4cz0iaHR0cDovL3d3\n" +
				"dy53My5vcmcvMjAwMS9YTUxTY2hlbWEiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAw\n" +
				"MS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTp0eXBlPSJ4czpzdHJpbmciPlBhY2U8L3NhbWw6QXR0\n" +
				"cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0iZ2l2ZW5O\n" +
				"YW1lIj48c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4bWxuczp4cz0iaHR0cDovL3d3dy53My5vcmcvMjAw\n" +
				"MS9YTUxTY2hlbWEiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEt\n" +
				"aW5zdGFuY2UiIHhzaTp0eXBlPSJ4czpzdHJpbmciPk1haGVzaDwvc2FtbDpBdHRyaWJ1dGVWYWx1\n" +
				"ZT48L3NhbWw6QXR0cmlidXRlPjxzYW1sOkF0dHJpYnV0ZSBOYW1lPSJtb2JpbGUiPjxzYW1sOkF0\n" +
				"dHJpYnV0ZVZhbHVlIHhtbG5zOnhzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIg\n" +
				"eG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeHNp\n" +
				"OnR5cGU9InhzOnN0cmluZyI+KzkxIDEyMzQ1Njc4OTA8L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9z\n" +
				"YW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0iYWNsIj48c2FtbDpBdHRyaWJ1dGVW\n" +
				"YWx1ZSB4bWxuczp4cz0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEiIHhtbG5zOnhz\n" +
				"aT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTp0eXBlPSJ4\n" +
				"czpzdHJpbmciPmNuPVBhY2Usb3U9QXBwbGljYXRpb24sb3U9QWNjZXNzQ29udHJvbCxvdT1Hcm91\n" +
				"cCxkYz1zY2huZWlkZXIsZGM9Y29tPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1\n" +
				"dGU+PHNhbWw6QXR0cmlidXRlIE5hbWU9ImNvbXBhbnlJZCI+PHNhbWw6QXR0cmlidXRlVmFsdWUg\n" +
				"eG1sbnM6eHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hIiB4bWxuczp4c2k9Imh0\n" +
				"dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hLWluc3RhbmNlIiB4c2k6dHlwZT0ieHM6c3Ry\n" +
				"aW5nIj42MzcyYzg1ZC04MWU5LTRjMmEtYjQ2ZC1kOWYxNWM1ODRhNGU8L3NhbWw6QXR0cmlidXRl\n" +
				"VmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0iam9iRnVuY3Rpb24i\n" +
				"PjxzYW1sOkF0dHJpYnV0ZVZhbHVlIHhtbG5zOnhzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hN\n" +
				"TFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0\n" +
				"YW5jZSIgeHNpOnR5cGU9InhzOnN0cmluZyI+WjAwMzwvc2FtbDpBdHRyaWJ1dGVWYWx1ZT48L3Nh\n" +
				"bWw6QXR0cmlidXRlPjxzYW1sOkF0dHJpYnV0ZSBOYW1lPSJmZWRlcmF0ZWRJZCI+PHNhbWw6QXR0\n" +
				"cmlidXRlVmFsdWUgeG1sbnM6eHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hIiB4\n" +
				"bWxuczp4c2k9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hLWluc3RhbmNlIiB4c2k6\n" +
				"dHlwZT0ieHM6c3RyaW5nIj4wYjMwNWJkZS04ZjVhLTQzNzAtYmIyMS1hYzY1ZTAxMzFkMDc8L3Nh\n" +
				"bWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0i\n" +
				"c3VybmFtZSI+PHNhbWw6QXR0cmlidXRlVmFsdWUgeG1sbnM6eHM9Imh0dHA6Ly93d3cudzMub3Jn\n" +
				"LzIwMDEvWE1MU2NoZW1hIiB4bWxuczp4c2k9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2No\n" +
				"ZW1hLWluc3RhbmNlIiB4c2k6dHlwZT0ieHM6c3RyaW5nIj5VcGRhdGVkPC9zYW1sOkF0dHJpYnV0\n" +
				"ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PHNhbWw6QXR0cmlidXRlIE5hbWU9ImNvdW50cnlDb2Rl\n" +
				"Ij48c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4bWxuczp4cz0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9Y\n" +
				"TUxTY2hlbWEiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5z\n" +
				"dGFuY2UiIHhzaTp0eXBlPSJ4czpzdHJpbmciPklOPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2Ft\n" +
				"bDpBdHRyaWJ1dGU+PHNhbWw6QXR0cmlidXRlIE5hbWU9InByaW1hcnlDb250YWN0Ij48c2FtbDpB\n" +
				"dHRyaWJ1dGVWYWx1ZSB4bWxuczp4cz0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEi\n" +
				"IHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhz\n" +
				"aTp0eXBlPSJ4czpzdHJpbmciPnRydWU8L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJp\n" +
				"YnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0iZW1haWwiPjxzYW1sOkF0dHJpYnV0ZVZhbHVlIHht\n" +
				"bG5zOnhzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRw\n" +
				"Oi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeHNpOnR5cGU9InhzOnN0cmlu\n" +
				"ZyI+bWFoZXNoLnZlbXBhbGxpQGdtYWlsLmNvbTwvc2FtbDpBdHRyaWJ1dGVWYWx1ZT48L3NhbWw6\n" +
				"QXR0cmlidXRlPjwvc2FtbDpBdHRyaWJ1dGVTdGF0ZW1lbnQ+PC9zYW1sOkFzc2VydGlvbj48L3Nh\n" +
				"bWxwOlJlc3BvbnNlPg==");
		normalLog.info("inside hello world servlet normal log");
		System.out.println("inside servlet");
		System.out.println(("Hello World from Servlet"));
		String rdirect= req.getParameter("redirect_uri");
		System.out.println("redirect from the request: "+rdirect);
		//String redirecUrl="https://abc.def.com/?user=MARIE-HÉLÈNE&password=appu";
		//String redirecUrl=" https://urlencoder.org/?user=appu$&userId=4ea97452-7906-4aad-927b-e0a20499ef2a#schneider";
		/*URI uri=null;
		try {
			uri= new URI(rdirect);
			System.out.println("Fragment from encoded string:  "+uri.getFragment());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}*/
		/*//String strs[]= redirecUrl.split("\\?");
		String redirectEndPoint=strs[0];
		String queryString=strs[1];*/
		try{
			/*UriBuilder uriBuilder = UriBuilder.fromUri(rdirect);
			uriBuilder.queryParam("user", "123");
			System.out.println("###########: "+uriBuilder.build());
			System.out.println("*********: "+uriBuilder.build().getQuery());
			req.getSession().setAttribute("id", "1234");
			System.out.println("session id sent:  "+req.getSession().getId());
			System.out.println(URLEncoder.encode(rdirect, "UTF-8"));
*/
            //*****************With this redirection wont happen. If it is with response.encodeRedirectUrl then redirectoin happens ***********
			resp.sendRedirect("https://urlencoder.org/?user=appu$&userId=4ea97452-7906-4aad-927b-e0a20499ef2a#schneider");
		//req.getRequestDispatcher("TestChange.jsp").forward(req, resp);
		//resp.sendRedirect("/MavenWeb/TestChange.jsp");
		System.out.println("after redirection");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		out.flush();
		out.close();
		
	}
}
