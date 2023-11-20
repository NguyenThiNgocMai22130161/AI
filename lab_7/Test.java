package lab_7;

public class Test {
public static void main(String[] args) {
	GA_NQueenAlgo ga = new GA_NQueenAlgo();
	ga.initPopulation();
	Node solution = ga.execute();
	if (solution != null) {
		System.out.println("Đã tìm thấy giải pháp:");
		solution.displayBoard();
	}else {
		System.out.println("Không tìm thấy giải pháp nào trong số lần lặp tối đa.");
	}
//	ga.initPopulation();
//	Node x =ga.getParentByRandomSelection();
//	x.displayBoard();
//	System.out.println("----------");
//	Node y=ga.getParentByRandomSelection();
//	y.displayBoard();
//	System.out.println("---------");
//	Node a=ga.reproduce(x, y);
//	a.displayBoard();
	//System.out.println("Test for GA_ALgo");
	System.out.println("H= "+solution.getH());
}
}
