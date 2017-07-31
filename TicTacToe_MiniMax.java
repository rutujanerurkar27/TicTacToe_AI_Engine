/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeai;

/**
 *
 * @author Administrator
 */
public class TicTacToe_MiniMax
{
    //generating the move through minimax
    public int Gen_Move(int player)
    {
        return BitToPos((minimax(player)&511));
    }
    public int getx()
    {
        return x;
    }
    public int geto()
    {
        return o;
    }
    public int get_board()
    {
        return (x|o);
    }
    public void NewGame()
    {
        x=o=0;
    }
    //following method is to check if the game is over or no
    public int isGameOver()
    {
        return check_move(x) ? 1 : check_move(o) ? -1 : ((x|o) & 511)==511?2:0;
    }
    //these variables are used to put on board for playing
    private int x=0,o=0;
    
    //here position variable will determine that which player will play the move in the game
    //if the position is positive (>0) then it will be x's move otherwise o's move
    private void insert(int position)
    {
        x = x | position &- ((position>>31)+1) & ~o;
        o = o | -position & (position>>31) & ~x;
    }
    //this method will clear off all the moves of positions in game
    private void clear(int position)
    {
        x = x & ~position;
        o = o & ~position;
    }
    //check player mthod is to check the player's move into the game
    private boolean check_move(int player)
    {
        return (player & 0x007) == 7 || 
               (player & 0x038) == 0x038 || 
	       (player & 0x1C0) == 0x1C0 || 
               (player & 0x049) == 0x49  || 
               (player & 0x092) == 0x92  || 
               (player & 0x124) == 0x124 || 
               (player & 0x111) == 0x111 ||
               (player & 0x054) == 0x54;
    }
    //check method for who won x o or is game draw?
    private int Game_Over()
    {
        return check_move(x) ? 2048 : check_move(o) ? 512 :((x|o) & 511)==511?1024:0;
    }
    //mini-max algorithm for actual game
    private int minimax(int player)
    {
        int end_of_game=Game_Over();
        if(end_of_game!=0)
        {
            return end_of_game;
        }
        int best_value = (player==1)?512:2048;
        for(int i=1;i<=256;i=i<<1)
        {
            int move = (~(x | o) & i);
            if (move != 0)
            {
		insert(player * move);
		int j = minimax(-player);
		best_value = player * (j & 0xfffffe00) > player * (best_value & 0xfffffe00) ? ((j & 0xfffffe00) | move) : best_value;
		clear(move);
            }
        }
        return best_value;
    }
    
    private int PosToBit(int pos)
    {
	return pos>=1 && pos<=9 ? 1<<(pos-1) : 0;
    }

    private int BitToPos(int bitNum)
    {
	int result = 1;
	while ( (bitNum=bitNum>>1) > 0 ) result++;   
        return result;
    }
    //computer move method
    public boolean move(int position, int player)
    {
        int p = PosToBit(position);
	if ( p!=0  && ( player==1 || player==-1 ) && ((x | o) & p)==0)
        {
            insert(p*player);
            return true;
        } 
        else
        {
            return false;
        }
    }
}
