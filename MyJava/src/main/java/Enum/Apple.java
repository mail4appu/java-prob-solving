package Enum;

/**
 * @author evarapp
 * 
 * Think this as types of Apples and their respective prices.
 * To define like this, there should be constructor  
 * 
 * The price can be access only through a variable(if public) or a getter
 *
 */
public enum Apple {  
	A(10), B(20), C(30), D(40), E(50), F(70);
	private int price;
	Apple(int i){
		this.price=i;

	}
	enum SmallApple{
		SA(1), SB(2);
		private int price;
		SmallApple(int i){
			this.price=i;

		}
		public int getPrice() {
			return price;
		}
	}

	enum BigApple{
		BA(100), BB(200);
		private int price;
		BigApple(int i){
			this.price=i;

		}
		public int getPrice() {
			return price;
		}

	}
	public int getPrice() {
		return price;
	}
}
