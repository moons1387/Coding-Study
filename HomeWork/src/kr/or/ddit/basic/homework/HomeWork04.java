package kr.or.ddit.basic.homework;

public class HomeWork04 {

	public enum Planet {
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 
		목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

		private double r;

		private Planet(double r) {
			this.r = r;
		}

		private double getR() {
			return r;
		}
	}
	public static void main(String[] args) {
		Planet[] planetArr = Planet.values();
		
		for (Planet p : planetArr) {
			System.out.println(p.name()+"의 면적 : "+p.getR()*p.getR()*4*Math.PI+"Km^2");
			
		}
	}
}
