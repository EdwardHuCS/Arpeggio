

import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;


public class MapGenerator
{
    public static int level = 0;

    public static int[][] grid;

    private static int pRow = 0;

    private static int pCol = 0;

    Random rand;

    static Scanner scan = new Scanner( System.in );


    /**
     * Initializes this map class.
     * 
     * @param level
     *            What floor your dungeon is on.
     * @param size
     *            How large the map is. An array of size x size. DO NOT MAKE
     *            THIS TOO BIG.
     */
    public MapGenerator( int level, int size )
    {
        this.level = level;
        grid = new int[size][size];
        rand = new Random();
    }


    public static void main( String[] args )
    {
        // char moveDir = ' ';
        // int playerTileType = 0;
        MapGenerator lv = new MapGenerator( 0, 10 );
        lv.initLevel();
        lv.makeLake();
        lv.makeRoad( 0, 0 );
        lv.makeTrees( 10 );

        // Create player icon
        // playerTileType = grid[pRow][pCol];
        // grid[pRow][pCol] = 5;

        System.out.println( "Welcome to level " + level );
        lv.printLevel();
        // while ( true )
        // {
        // moveDir = scan.next().charAt( 0 );
        // playerTileType = lv.movePlayer( moveDir, playerTileType );
        // lv.printLevel();
        // }
    }


    // private int movePlayer( char direction, int playerTileType )
    // {
    // int temp = 0;
    // if ( direction == 's' )
    // {
    // // Checks if character is at lakeside or at the boundrary
    // if ( pRow == grid.length - 1 || grid[pRow + 1][pCol] == '~' )
    // {
    // System.out.println( "You twiddle your thumbs." );
    // System.out.println( "You can't move there!" );
    // return playerTileType;
    // }
    // System.out.println( "Moving down." );
    // grid[pRow][pCol] = playerTileType;
    // temp = grid[pRow + 1][pCol];
    // grid[pRow + 1][pCol] = 5;
    // pRow++;
    // return temp;
    // }
    // else if ( direction == 'd' )
    // {
    // // Checks if character is at lakeside or at the boundrary
    // if ( pCol == grid[0].length - 1 || grid[pRow][pCol + 1] == '~' )
    // {
    // System.out.println( "You twiddle your thumbs." );
    // System.out.println( "You can't move there!" );
    // return playerTileType;
    // }
    // System.out.println( "Moving right." );
    // grid[pRow][pCol] = playerTileType;
    // temp = grid[pRow][pCol + 1];
    // grid[pRow][pCol + 1] = 'O';
    // pCol++;
    // return temp;
    // }
    // else if ( direction == 'w' )
    // {
    // // Checks if character is at lakeside or at the boundrary
    // if ( pRow == 0 || grid[pRow - 1][pCol] == '~' )
    // {
    // System.out.println( "You can't move there!" );
    // System.out.println( "You twiddle your thumbs." );
    // return playerTileType;
    // }
    // System.out.println( "Moving up." );
    // grid[pRow][pCol] = playerTileType;
    // temp = grid[pRow - 1][pCol];
    // grid[pRow - 1][pCol] = 'O';
    // pRow--;
    // return temp;
    // }
    // else if ( direction == 'a' )
    // {
    // // Checks if character is at lakeside or at the boundrary
    // if ( pCol == 0 || grid[pRow][pCol - 1] == '~' )
    // {
    // System.out.println( "You can't move there!" );
    // System.out.println( "You twiddle your thumbs." );
    // return playerTileType;
    // }
    // System.out.println( "Moving left." );
    // grid[pRow][pCol] = playerTileType;
    // temp = grid[pRow][pCol - 1];
    // grid[pRow][pCol - 1] = 'O';
    // pCol--;
    // return temp;
    // }
    // else
    // {
    // System.out.println( "You twiddle your thumbs." );
    // return playerTileType;
    // }
    // }

    /**
     * 
     * Sets the whole map to plain tiles ('|').
     */
    public void initLevel()
    {
        for ( int row = 0; row < grid.length; row++ )
        {
            for ( int col = 0; col < grid[0].length; col++ )
            {
                grid[row][col] = 0;
            }
        }
    }


    /**
     * 
     * Prints out the "grid" array.
     */
    public void printLevel()
    {
        for ( int row = 0; row < grid.length; row++ )
        {
            for ( int col = 0; col < grid[0].length; col++ )
            {
                System.out.print( "[" + grid[row][col] + "]" );
            }
            System.out.println();
        }
    }


    /**
     * 
     * Makes a randomly-sized square lake, consisting of water ('~') tiles,
     * which is, at largest, equal to the size of the map / 2. Then, it is
     * placed randomly on the map.
     */
    public void makeLake()
    {
        int lakeSize = rand.nextInt( grid.length / 2 );
        int lakeRow = rand.nextInt( grid.length );
        int lakeCol = rand.nextInt( grid[0].length );

        for ( int row = 0; row < lakeSize && row < grid.length - lakeRow; row++ )
        {
            for ( int col = 0; col < lakeSize && col < grid[0].length - lakeCol; col++ )
            {
                grid[row + lakeRow][col + lakeCol] = 3;
            }
        }
    }


    /**
     * Uses recursion to make a winding road from the upper corner of the map.
     * If the road reaches the end of the map, or a lake, it ends.
     * 
     * @param row
     *            the starting row of the road (usually set to 0)
     * @param col
     *            the starting column of the road (usually set to 0)
     */
    public void makeRoad( int row, int col )
    {
        int direction = rand.nextInt( 2 );
        if ( row < grid.length - 1 && col < grid[0].length - 1 )
        {
            if ( direction == 0 && grid[row][col] == 0
                && grid[row + 1][col] == 0 )
            {
                grid[row][col] = 2;
                makeRoad( row + 1, col );
            }
            else if ( direction == 1 && grid[row][col] == 0
                && grid[row][col + 1] == 0 )
            {
                grid[row][col] = 2;
                makeRoad( row, col + 1 );
            }
            else
            {
                return;
            }
        }
        else
        {
            return;
        }
    }


    /**
     * Scatters tree ('+') tiles across the map. Trees can only override plain
     * ('|') tiles.
     * 
     * Precondition: numTrees is less than the number of open spaces!!
     * 
     * @param numTrees
     *            now forested the region. Set to 0 for open plains or deserts.
     */
    public void makeTrees( int numTrees )
    {
        int x = rand.nextInt( grid.length );
        int y = rand.nextInt( grid[0].length );
        for ( int i = 0; i < numTrees; i++ )
        {
            while ( grid[x][y] != 0 )
            {
                x = rand.nextInt( grid.length );
                y = rand.nextInt( grid[0].length );
            }
            grid[x][y] = 1;
        }
    }


    /**
     * Detects if there is a viable road path from one end of the map to the other.
     * @param row the row to start with
     * @param col the col to start with
     * @return if a path exists
     */
    public boolean pathExists( int row, int col )
    {
        boolean result = true;
        if ( row < grid.length - 1 && col < grid[0].length - 1 )
        {
            if ( grid[row][col] != 'w' && grid[row + 1][col] == 'w' )
            {
                pathExists( row + 1, col );
            }
            else if ( grid[row][col] != 'w' && grid[row][col + 1] != 'w' )
            {
                pathExists( row, col + 1 );
            }
            else
            {
                return false;
            }
        }
        return true;
    }

}
