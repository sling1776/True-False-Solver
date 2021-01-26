import java.io.*;
import java.util.*;

public class Solver {
    public static final int FALSE = -1;
    public static final int TRUE = 1;
    public static final int UNKNOWN = 0;

    public ArrayList<int[]> clauses = new ArrayList<int[]>();
    public ArrayList<int[]> queryClauses = new ArrayList<int[]>();

    public void addClause(int[] clause){
        clauses.add(clause.clone());
    }

    public void clearClauses(){
        clauses.clear();
    }

    public void addQueryClause(int[] clause){
        queryClauses.add(clause.clone());
    }

    public void clearQueryClauses(){
        queryClauses.clear();
    }


}
