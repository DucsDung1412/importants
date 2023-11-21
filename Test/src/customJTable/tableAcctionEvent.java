package customJTable;

public interface tableAcctionEvent {
	public void onNew(int row);
	public void onDelete(int row);
	public void onSearch(int row);
}
