package desafio

data class Aluno(val nome: String, val sobrenome: String, val codAluno: Int) {

    override fun equals(other: Any?): Boolean {
        if(other is Aluno){
        if(codAluno == other.codAluno){
            return true
        }
        }
        return false
    }
}