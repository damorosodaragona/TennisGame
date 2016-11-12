public class Match {
	private Player player1;
	private Player player2;
	private int countP1;
	private int countP2;

	public Match(Point p) {
		player1 = p.getPlayer1();
		player2 = p.getPlayer2();
		checkHowWon(p);
	}

	public boolean isWon() {
		if (!(countP1 == 4) && !(countP2 == 4)) {

			return false;

		}
		if (!(countP1 >= (countP2 + 2))
				&& !(countP2 >= (countP1 + 2))) {

			return false;

		} else {

			return true;
		}

	}

	public String addPoint(Point p) throws IllegalPlayerPoint {

		checkPlayer(p.getPlayer1(), p.getPlayer2());
		checkHowWon(p);
		String state = "";

		if (!isWon()) {

			state = player1.toString() + "-" + player2.toString();

		} else if (player1.getScoreInt() == player2.getScoreInt() && countP1 == 3 && countP2 == 3) {

			state = "deuce";

		} else if (countP1 == 3 && countP2 == 3 && player1.getScoreInt() == (player2.getScoreInt() + 1)) {

			state = "advantage - " + player2.toString();

		} else if (countP1 == 3 && countP2 == 3 && player2.getScoreInt() == (player1.getScoreInt() + 1)) {

			state = player1.toString() + " - advantage";

		} else if (countP1 == 4 && countP1 >= (countP2 + 2)) {

			state = "player 1 wins";

		} else if (countP2 == 4 && countP2 >= (countP1 + 2)) {

			state = "player 2 wins";
		}

		return state;

	}

	private void checkHowWon(Point p) {
		if (p.getWinner() == player1) {

			countP1++;

		} else {

			countP2++;

		}

	}

	private void checkPlayer(Player p1, Player p2) throws IllegalPlayerPoint {
		if (!(p1 == player1) || !(p2 == player2)) {

			throw new IllegalPlayerPoint();

		}

	}
}
