import java.util.ArrayList;
import java.util.Arrays;

public class Logic {
    public class KnowledgeBase{
        ArrayList<Or> knowledge;

        public void derive(){
            for(Or conjunct: knowledge){
                for(Or conjunct2: knowledge){
                    for(SymbolParent item1: conjunct.symbols){
                        for(SymbolParent item2: conjunct2.symbols){
                            //find a pair
                            if(item1 instanceof Not && item2.equals(((Not) item1).sym)){
                            //merge sets removing the pair and add to knowledge
                                //copy the conjuncts and remove the item from each
                                Or con_cop = conjunct.copy();
                                Or con2_cop = conjunct2.copy();
                                con_cop.symbols.remove(item1);
                                con2_cop.symbols.remove(item2);
                                //make a new or with the conjuncts
                                Or newderived = new Or(con_cop.symbols, con2_cop.symbols);
                                //add the or to the knowledge base
                                addNew(newderived);
                            }
                        }
                    }
                }
            }

        }

        public void addNew (Or disjunctiveSet){
            for(Or set: knowledge){
                if(disjunctiveSet.equals(set)){
                    return;
                }
            }
            knowledge.add(disjunctiveSet);
        }

        public boolean query(Or qItem){
            return false;
        }
    }

    public class Or implements Cloneable{
        ArrayList<SymbolParent> symbols;

        public Or(SymbolParent... symbList){
                symbols.addAll(Arrays.asList(symbList));
            }

        public Or(SymbolParent[]... symbList){
            for(SymbolParent[] slist: symbList){
                symbols.addAll(Arrays.asList(slist));
            }
        }

        public Or(ArrayList<SymbolParent> symbs) {
            symbols = symbs;
        }

        public Or(ArrayList<SymbolParent> symbs1, ArrayList<SymbolParent> symbs2) {
            symbols.addAll(symbs1);
            symbols.addAll(symbs2);
        }

        public Or copy(){
            Or myCopy = new Or(symbols);
            return myCopy;
        }

    }

    private class SymbolParent{
        public boolean evaluate(){
            return true;
        }

    }

    public class Symbol extends SymbolParent{
        public boolean evaluate(){
            return true;
        }
    }

    public class Not extends SymbolParent{
        public SymbolParent sym;
        public Not(SymbolParent symbol) {
            sym = symbol;
        }
        public boolean evaluate(){
            return !sym.evaluate();
        }

    }
}
