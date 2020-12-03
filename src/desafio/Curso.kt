package desafio

data class Curso(val nome: String, val codDeCurso: Int, val professorTitular: ProfessorTitular, var professorAdjunto: ProfessorAdjunto, val qtdMaxDeAlunos: Int) {
    var listaDeAlunos = mutableListOf<Aluno>()
    var qtdDeAlunosMatriculados = 0

    fun adicionarUmAluno(umAluno: Aluno):Boolean{
        if(qtdDeAlunosMatriculados<qtdMaxDeAlunos){
            qtdDeAlunosMatriculados++
            listaDeAlunos.add(umAluno)
        return true
    } else {
        return false
        }
    }

    fun excluirAluno(umAluno: Aluno){
        if(qtdDeAlunosMatriculados>0) {
            qtdDeAlunosMatriculados--
            listaDeAlunos.remove(umAluno)
            println("O aluno ${umAluno.nome} foi removido do curso $nome")
        }else{
            println("Impossível retirar aluno, pois não existem alunos matriculados nesse curso.")
        }

    }
}