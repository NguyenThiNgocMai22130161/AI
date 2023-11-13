package A.student;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
//		row++; //di chuyển hậu đi 1 hàng
//		if (row == Node.N) 
//			row = 0;
//	}
		int limit=Node.N;
		if(this.row==limit-1) {
			setRow(0);
		}else {
			setRow(row+1);
		}
		}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
//		// kt có cùng hàng or cột ko?
//		if (row == q.row || column == q.column) {
//		   return true;
//		}
//		// có cùng đường chéo?
//		int rowDiff = Math.abs(row - q.row);
//		int colDiff = Math.abs(column - q.column);
//        return rowDiff == colDiff;
//	}
		if((Math.abs(this.row-q.row))==(Math.abs(this.column-q.column))||(this.row==q.row)){
			return true;
		}else {
			return false;
		}
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
