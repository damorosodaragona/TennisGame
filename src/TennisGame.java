public class TennisGame {
	private Player player1;
	private Player player2;
	private int countP1;
	private int countP2;
	private boolean matchWin = false;

	public TennisGame(Point p) throws InvalidScoreException {
		player1 = p.getPlayer1();
		player2 = p.getPlayer2();

	}

	private void isAlreadyWin() throws AlreadyWonMatchException {
		if (matchWin) {
			throw new AlreadyWonMatchException();
		}
	}

	public boolean isWon() throws AlreadyWonMatchException {
		isAlreadyWin();
		if (!(countP1 >= 4) && !(countP2 >= 4)) {

			return false;

		}
		if (!(countP1 >= (countP2 + 2)) && !(countP2 >= (countP1 + 2))) {

			return false;

		} else {
			matchWin = true;
			return true;
		}

	}

	public String addPoint(Point p)
			throws IllegalPlayerPoint, InvalidScoreException, IllegalMatchStateException, AlreadyWonMatchException {

		checkPlayer(p.getPlayer1(), p.getPlayer2());
		checkHowWon(p);
		String state = "";
		isWon();

		if (!matchWin) {
			if (countP1 == (countP2 + 1) && countP1 >= 3 && countP2 >= 3) {

				state = "advantage - " + player2.getScore().toString();

			} else if (countP2 == (countP1 + 1) && countP1 >= 3 && countP2 >= 3) {

				state = player1.getScore().toString() + " - advantage";

			} else if (player1.getScoreInt() == player2.getScoreInt() && countP1 >= 3 && countP2 >= 3) {

				state = "deuce";

			} else {
				state = player1.getScore().toString() + "-" + player2.getScore().toString();
			}

		} else if (matchWin) {
			if (countP1 >= 4 && countP1 >= (countP2 + 2)) {

				state = "player 1 wins";

			} else if (countP2 >= 4 && countP2 >= (countP1 + 2)) {

				state = "player 2 wins";

			}
		}

		else {
			
			throw new IllegalMatchStateException();
		
		}

		return state;

	}

	private void checkHowWon(Point p) throws InvalidScoreException {
		if (p.getWinner() == player1.getId()) {
			if (player1.getScoreInt() >= 3) {

				countP1++;

			} else {

				player1.setScore(new Score(player1.getScoreInt() + 1));

				countP1++;
			}

		} else if (p.getWinner() == player2.getId()) {
			if (player2.getScoreInt() >= 3) {

				countP2++;

			} else {

				player2.setScore(new Score(player2.getScoreInt() + 1));

				countP2++;
			}

		}

	}

	private void checkPlayer(Player p1, Player p2) throws IllegalPlayerPoint {
		if (!(p1 == player1) || !(p2 == player2)) {

			throw new IllegalPlayerPoint();

		}

	}

}
