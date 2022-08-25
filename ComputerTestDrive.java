class ComputerTestDrive{
	public static void main(String[] args){
		Computer c = new Computer(5);
		System.out.println(c.toString());

		System.out.println(c.guess("12345"));
		System.out.println(c.guess("02235"));
		System.out.println(c.guess("12305"));
		System.out.println(c.guess("1233445"));
		System.out.println(c.guess("1234567"));
		System.out.println(c.guess("0"));
		System.out.println(c.guess("1"));
	}
}