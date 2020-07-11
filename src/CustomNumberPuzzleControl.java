import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		int check=emptyCellId;
		for (int i=0; i<16; i++)
		{
			if (buttons[i] == buttonClicked)
			{
				check = i;
				break;
			}
		}
		
		if (check == emptyCellId+4 || check == emptyCellId-4 || check == emptyCellId+1 || check == emptyCellId-1)
		{
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId=check;
		}
		
		return emptyCellId;
	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		boolean check[] = new boolean[16];
		
		int i=0;
		while (i<15)
		{	
			int a = getRandomNumber();
			
			a = a%16;
			System.out.println(a);
			if (a==0)
				continue;
			else if (check[a] == true)
				continue;
			else
			{
				arr[i]=a;
				i++;
				check[a]=true;
			}
		}
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		
		for (int i=1; i<=15; i++)
		{
			if (i!=arr[i-1])
			{
				winner = false;
				break;
			}
		}

		return winner;
	}
}