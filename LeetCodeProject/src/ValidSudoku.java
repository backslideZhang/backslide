import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ValidSudoku {
	public void solution(){
		System.out.println(isValidSudoku(new char[][]{
				new char[]{'5','3','.','.','7','.','.','.','.'},
				new char[]{'6','.','.','1','9','5','.','.','.'},
				new char[]{'.','9','8','.','.','.','.','6','.'},
				new char[]{'8','.','.','.','6','.','.','.','3'},
				new char[]{'4','.','.','8','.','3','.','.','1'},
				new char[]{'7','.','.','.','2','.','.','.','6'},
				new char[]{'.','6','.','.','.','.','2','8','.'},
				new char[]{'.','.','.','4','1','9','.','.','5'},
				new char[]{'.','.','.','.','8','.','.','7','9'},
		}));
	}
	
	public boolean isValidSudoku(char[][] board) {
		List<Character> checkListRow = new ArrayList<Character>();
		List<Character> checkListCol = new ArrayList<Character>();
		Map<Integer,List<Character>> checkListSquare = new HashMap<Integer,List<Character>>();
		checkListSquare.clear();
		for (int i = 0; i < 9; i++){
			ArrayList<Character> tmp = new ArrayList<Character>();
			checkListSquare.put(i, tmp);
			tmp.clear();
		}
		for (int i = 0; i < 9; i++){
			checkListRow.clear();
			checkListCol.clear();
			for (int j = 0; j < 9; j++){
				if (board[i][j] != '.'){
					if (!checkListRow.contains(board[i][j])){
						checkListRow.add(board[i][j]);
					}else{
						return false;
					}
					if (!checkListSquare.get((i / 3) * 3 + j / 3).contains(board[i][j])){
						checkListSquare.get((i / 3) * 3 + j / 3).add(board[i][j]);
					}else{
						return false;
					}
					
				}
				if (board[j][i] != '.'){
					if (!checkListCol.contains(board[j][i])){
						checkListCol.add(board[j][i]);
					}else{
						return false;
					}
				}
			}
		}
		return true;
    }
}
