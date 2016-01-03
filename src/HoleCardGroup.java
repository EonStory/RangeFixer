//This class isn't to be used in the main monte carlo simulation.
//unhappy with the existence of this class, skipping it for now, its not necessary
/*
public class HoleCardGroup {
	//this is a reference to the 13x13 grid of poker hands.
	//top left starts at 0, bottom right is 168
	
	
	private static HoleCardGroup[] allHoleCardGroups = new HoleCardGroup[169];
	
	private HoleCards[] holeCardGroup;
	
	//construct allHoleCardGroups
	static {
		for (int i = 0; i < 13; i++) {//rows
			for (int j = 0; j < 13; j++) {//columns
				
			}
		}
	}
	
	private HoleCardGroup(HoleCards[] holeCardGroup) {
		this.holeCardGroup = holeCardGroup;
	}
	
	
	public int rankOfFirstCard(int row, int column)
    {
        for (int i = 0; i < 13; i++)
        {
            if (row == i || column == i)
            {
                return 12 - i;
            }
        }
        
        //hopefully this never occurs
        throw new IllegalStateException("bad times :(");
    }
	
	public int rankOfSecondCard(int row, int column)
    {
        if (row == column)//pocket pair
        {
            return rankOfFirstCard(row, column);
        }

        if (row > column) //offsuit
        {
            return 12 - row;
        }
        if (row < column) //suited
        {
            return 12 - column;
        }
        throw new IllegalStateException("rank of SECOND card is bad");
    }
}
*/