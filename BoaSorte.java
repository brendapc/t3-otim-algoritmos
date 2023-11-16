import java.util.HashMap;
import java.util.Map;

public class BoaSorte {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, forneça uma mensagem como argumento de linha de comando.");
            return;
        }

        String mensagem = args[0];

        mensagem = mensagem.replaceAll(" ", "").toUpperCase() + "!" ;

        String[] elementosQuimicos = {
            "H", "He", "Li", "Be", "B", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "U", "Do", "O",
            "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Ni", "Co", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr",
            "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd",
            "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg",
            "Tl", "Pb", "Bi", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg",
            "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og", "S", "Or", "Oa", "Ou", "Oc", "Oe", "Oo", "Ox",
            "Te", "Or", "Te", "Oa", "Te", "Ou", "Te", "Oc", "Te", "Oe", "Te", "Oo", "Te", "Ox", "O", "Rr", "Oa", "Ru", "Ou", "Rc",
            "Mi", "Me", "Nh", "A", "R", "O", "N", "D", "O", "M", "I", "N", "G", "Pa", "Ra", "En", "Sa", "Ge", "Mu", "Do", "Em"
        };

        Map<Integer, String> combinacoes = new HashMap<>();
        boolean encontrou = encontrarCombinacao(mensagem, elementosQuimicos, 0, combinacoes);

        if (encontrou) {
            System.out.println("Combinação de elementos químicos para a mensagem:");
              for (int i = 0; i < mensagem.length(); i++) {
                System.out.println(mensagem.charAt(i) + " | " + combinacoes.get(i));
            }
        } else {
            System.out.println("Não foi possível encontrar uma combinação de elementos químicos para a mensagem.");
        }
    }

    public static boolean encontrarCombinacao(String mensagem, String[] elementosQuimicos, int index, Map<Integer, String> combinacoes) {
        if (index == mensagem.length()) {
          
            return false;
        }
        
        for (String elemento : elementosQuimicos) {

            if (mensagem.startsWith(elemento.toUpperCase(), index)) {
                int novoIndex;   
                if(elemento.length() > 1 && combinacoes.size()+1 < mensagem.length()) { 
                    novoIndex = index + 2;
                    combinacoes.put(index, elemento);

                    if (encontrarCombinacao(mensagem, elementosQuimicos, novoIndex, combinacoes)) {
                        return true;
                    }
                }
                else {
                    if(combinacoes.size()+1 < mensagem.length()){
                        novoIndex = index + 1;
                        combinacoes.put(index, elemento);

                        if (encontrarCombinacao(mensagem, elementosQuimicos, novoIndex, combinacoes)) {
                            return true;
                        }
                    };
                }
                combinacoes.put(index+1, elemento);
             combinacoes.remove(index);
            }
        }

        return true;
    }
}
