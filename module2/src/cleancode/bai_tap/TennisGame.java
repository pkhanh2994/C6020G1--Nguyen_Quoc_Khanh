package cleancode.bai_tap;

public class TennisGame {
    public static final char SUBTRACTION = '-';
    private String player1Name;
    private String player2Name;
    public static final int ZERO = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;


    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }


    public static String getEqualScore(int scoreOfPlayer ) {
       String result = "";
            switch (scoreOfPlayer) {
                case ZERO:
                    result = "Love-All";
                    break;

                case FIFTEEN:

                    result = "Fifteen-All";
                    break;
                case THIRTY:
                    result = "Thirty-All";
                    break;
                case FORTY:
                    result = "Forty-All";
                    break;
                default:
                    result = "Deuce";
                    break;

            }
        return result;
        }


    public static String getScore(int scoreOfPlayer) {
        String score = "";
        switch (scoreOfPlayer) {
            case ZERO:
                score += "Love";
                break;
            case FIFTEEN:
                score += "Fifteen";
                break;
            case THIRTY:
                score += "Thirty";
                break;
            case FORTY:
                score += "Forty";
                break;
        }
        return score;
    }
    public static String getDifferentScore(int player1Score, int player2Score) {
        String score = getScore(player1Score);
        score += SUBTRACTION;
        score += getScore(player2Score);
        return score;
    }
    public String getWinner(int scoreOfPlayer1,int scoreOfPlayer2){
        String winner="";
        if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4) {
            int minusResult = scoreOfPlayer1 - scoreOfPlayer2;
            if (minusResult == 1) winner = "Advantage player1";
            else if (minusResult == -1) winner = "Advantage player2";
            else if (minusResult >= 2) winner = "Win for player1";
            else winner = "Win for player2";
        }
        return winner;
    }
}