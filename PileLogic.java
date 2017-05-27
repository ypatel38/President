import java.util.ArrayList;
import java.lang.StringBuilder;

public class PileLogic{
	private int pileValue;
	private int passPlayCounter;
	
	public PileLogic(){
		this.pileValue = 0;
		this.passPlayCounter = 0;
	}
	
	public boolean checkClick (ArrayList<Card> queuedCards, Card chosenCard){

		if(queuedCards.size()==1 && queuedCards.get(0).getValue()==2 && chosenCard.getValue()==2 && chosenCard.getSuit()!=queuedCards.get(0).getSuit()) //account for 2's
			return false;
			
		for(int i = 0; i< queuedCards.size(); i++){
			if(chosenCard.getValue() != queuedCards.get(i).getValue())
				return false;
		}
		return true;
	}
	
	public void checkRefresh(){ //called at the start of a turn
		if(this.passPlayCounter == 3)
			this.pileValue = 0;
	}
	
	public boolean checkWin(ArrayList<Card> hand){
		if(hand.size()<5){
			for(int i = 0; i < hand.size(); i++){
				if(hand.get(i).getValue()!=2)
					return false;
			}
			//if(hand.size()!=0)
				//throwTwos();
			return true;
		}
		return false;
	}
	
	public boolean checkPlay (ArrayList<Card> queuedCards){
		StringBuilder queuePower = new StringBuilder();
		if(((queuedCards.size() == 1 && queuedCards.get(0).getValue()==2) || queuedCards.size()==4)){
			this.pileValue = 0;
			this.passPlayCounter = 0;
			return true;
		}
		for(int i = 0; i < queuedCards.size(); i++)
			queuePower.append(Integer.toString(queuedCards.get(i).getValue()));

		String queuePowerString = queuePower.toString();

			
		//can deal with finishing a set here at a later time
		//take append the two strings and check if it is 4x a single number
		/*  
			String checkFour = pileValue.toString(pileValue);
			checkFour.append(queuePower);
			String fourOfAKind;
			for(int i = 0; i < 4; i++){
				fourOfAKind.append(queuedCards.get(0));
			}
			if(checkFour == fourOfAKind){
				this.pileValue = 0;
				this.passPlayCounter = 0;
				this.playerTurn = playerTurn;
				return true;
			}
		*/

		int powerValue = (queuePowerString.equals("")) ? 0 : Integer.parseInt(queuePowerString);
		if(powerValue > pileValue){ //currently doesnt handle equal since the prev will
			this.pileValue = Integer.parseInt(queuePowerString);
			this.passPlayCounter = 0;
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean checkPass(ArrayList<Card> queuedCards){
		if (queuedCards.size() == 0){
			this.passPlayCounter++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkPlayButton (ArrayList<Card> queuedCards){
		StringBuilder queuePower = new StringBuilder();
		if(((queuedCards.size() == 1 && queuedCards.get(0).getValue()==2) || queuedCards.size()==4))
			return true;
		
		for(int i = 0; i < queuedCards.size(); i++)
			queuePower.append(Integer.toString(queuedCards.get(i).getValue()));
		//System.out.println("queuePower: " + queuePower);
		String queuePowerString = queuePower.toString();
		//System.out.println("queuePowerString: " + queuePowerString);
			
		//can deal with finishing a set here at a later time
		//take append the two strings and check if it is 4x a single number
		/*  
			String checkFour = pileValue.toString(pileValue);
			checkFour.append(queuePower);
			String fourOfAKind;
			for(int i = 0; i < 4; i++){
				fourOfAKind.append(queuedCards.get(0));
			}
			if(checkFour == fourOfAKind)
				return true;
		*/

		int powerValue = (queuePowerString.equals("")) ? 0 : Integer.parseInt(queuePowerString);
		//System.out.println("powerValue: " + powerValue);

		if(powerValue > pileValue) //currently doesnt handle equal since the prev will
			return true;
		else
			return false;
	}
	
	public boolean checkPassButton(ArrayList<Card> queuedCards){
		if (queuedCards.size() == 0)
			return true;
		else 
			return false;
	}
}