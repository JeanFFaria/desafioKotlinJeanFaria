package desafio

abstract class Professor(val nome: String, val sobrenome: String, val tempoDeCasa: Int, val codDeProfessor: Int) {


    override fun equals(other: Any?): Boolean {
        if (other is Professor) {
            if(codDeProfessor == other.codDeProfessor){
                return true
            }
        }
        return false
    }
}