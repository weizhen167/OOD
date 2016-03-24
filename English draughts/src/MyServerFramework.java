
import java.util.ArrayList;
import java.util.Collection;



public class MyServerFramework extends ServerFramework{
    Draught game = Draught.make8x8game();
    
    MyServerFramework(){        
    }
    
    @Override
    protected void runGame(ClientView player1, ClientView player2) {
        int i = 0;
        while (i < 32){
            if(i < 12){
            player1.setPosition(i, false, false);
            player2.setPosition(i, false, false);
            }
            if(i > 19){
                player1.setPosition(i, true, false);
                player2.setPosition(i, true, false);
            }
            i++;
        }
        game.moveStep0();
        player2.waitingForOtherPlayer();
        p1RunGame(player1, player2);//player 2 wait
    }

    void p1RunGame(ClientView player1, ClientView player2) {        
        MyMove moveset = player1.getChoice(allmoves());//get player1's chose
        String currentplayer = game.whoesmove();
        game.moveStep1(match(moveset.from()));//get player1 Piece
        game.moveStep2(match(moveset.to()));//move player1'Piece to the target
        player1.setPosition(moveset.to, true, game.getBoard().get(moveset.to).isKing());//display new Piece
        player1.clearPosition(moveset.from());//delete old Piece
        if(game.isGameOver()){
            player1.displayResult(true);//Notify player1 game is over and player1 is winner
            player2.displayResult(false);//Notify player2 game is over and player1 is winner
        }
        if(game.whoesmove().equals(currentplayer)){
            p1RunGame(player1, player2);//if player1 can still move, make a new run
        } else {
            player1.waitingForOtherPlayer();//player 2 wait
            p2RunGame(player1, player2);//if player1 can not move, take turns
        }
    }
    
    int match(int i){
        ArrayList<Integer> l = game.currentIdMoveList;
        int id = 0;
        while(id < l.size()){
            if(l.get(id) == i){
                break;
            }
            id++;
        }
        return id+1;
    }

    void p2RunGame(ClientView player1, ClientView player2) {        
        MyMove moveset = player2.getChoice(allmoves());//get player2's chose
        String currentplayer = game.whoesmove();
        game.moveStep1(match(moveset.from()));//get player2 Piece
        game.moveStep2(match(moveset.to()));//move player2'Piece to the target
        player2.setPosition(moveset.to, false, game.getBoard().get(match(moveset.to)).isKing());//display new Piece
        player2.clearPosition(moveset.from());//delete old Piece
        if(game.isGameOver()){
            player2.displayResult(true);//Notify player2 game is over and player2 is winner
            player1.displayResult(false);//Notify player1 game is over and player2 is winner
        }
        if(game.whoesmove().equals(currentplayer)){
            p2RunGame(player2, player1);//if player2 can still move, make a new run
        } else {
            player2.waitingForOtherPlayer();
            p1RunGame(player2, player1);//if player2 can not move, take turns
        }
    }
    
    
    public Collection<MyMove> allmoves(){
        ArrayList<Integer> l = game.currentIdMoveList;
        ArrayList<MyMove> my = new ArrayList<MyMove>();
        int size1 = l.size();
        int i = 0;
        
        while(i < size1){
            Draught.Box old = game.getBoard().get(game.currentIdMoveList.get(i));
            ArrayList<Integer> l2 = new ArrayList<Integer>(old.getExistBoxIds());
            int i2 = 0;
            while(i2 < l2.size()){
                MyMove m = new MyMove(old.getId(), l2.get(i2));//inner
                my.add(m);
                i2++;
            }
            i++;
        }
        Collection<MyMove> m1 = my;
        return m1;
    }

    
    public class MyMove implements ClientView.Move {
        int from = 0;
        int to = 0;

        MyMove(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int from() {
            return from;
        }

        @Override
        public int to() {
            return to;
        }

   }

    // can display by set board
   

}
