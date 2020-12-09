package desafio

data class Curso(val nomeCurso: String, val codDeCurso: Int,  val qtdMaximaDeAlunos: Int) {

    var listaDeAlunos = mutableListOf<Aluno>()
    var qtdDeAlunosMatriculados = 0

    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null

    override fun equals(other: Any?): Boolean {
        if (other is Curso){
            if (codDeCurso == other.codDeCurso){
                return true
            }
        }
            return false
    }

    fun adicionarUmAluno(umAluno: Aluno):Boolean{
        if(qtdDeAlunosMatriculados<qtdMaximaDeAlunos){
            qtdDeAlunosMatriculados++
            listaDeAlunos.add(umAluno)
            println("O aluno ${umAluno.nome} foi adicionado ao curso $nomeCurso")
        return true
    } else {
            println("Impossível adicionar aluno ${umAluno.nome} ao curso $nomeCurso, pois não há vagas disponiveis.")
        return false
        }
    }

    fun excluirAluno(umAluno: Aluno){
        if(qtdDeAlunosMatriculados>0) {
            qtdDeAlunosMatriculados--
            listaDeAlunos.remove(umAluno)
            println("O aluno ${umAluno.nome} foi removido do curso $nomeCurso")
        }else{
            println("Impossível retirar aluno, pois não existem alunos matriculados nesse curso.")
        }

    }
}