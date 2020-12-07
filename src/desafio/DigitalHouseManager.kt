package desafio

class DigitalHouseManager(var listaDeAlunos: MutableList<Aluno>, var listaDeProfessores: MutableList<Professor>, var listaDeCursos: MutableList<Curso>, var listaDeMatriculas: MutableList<Matricula>) {


    fun registrarCurso(nome: String, codigoDoCurso: Int, qtdMaxDeAluno: Int){

        val curso = Curso(nomeCurso = nome, codDeCurso = codigoDoCurso, qtdMaximaDeAlunos = qtdMaxDeAluno)
        listaDeCursos.add(curso)

    }

    fun excluirCurso(codigoDoCurso: Int){
        for (curso in listaDeCursos){
            if (curso.codDeCurso == codigoDoCurso){
                listaDeCursos.remove(curso)
            }
        }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int){

        val professorAdjunto = ProfessorAdjunto(nome = nome, sobrenome = sobrenome, tempoDeCasa = 0, codDeProfessor = codigoProfessor, qtdHorasMonitoria = quantidadeDeHoras)
        listaDeProfessores.add(professorAdjunto)
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String){

        val professorTitular = ProfessorTitular(nome = nome, sobrenome = sobrenome, tempoDeCasa = 0, codDeProfessor = codigoProfessor,especialidade = especialidade )
        listaDeProfessores.add(professorTitular)
    }

    fun excluirProfessor(codigoProfessor: Int){
        for (professor in listaDeProfessores){
            if (professor.codDeProfessor == codigoProfessor){
                listaDeProfessores.remove(professor)
            }
        }
    }

    fun matricularAluno1(nome: String, sobrenome: String, codigoAluno: Int){

        val aluno = Aluno(nome = nome, sobrenome = sobrenome, codAluno = codigoAluno)
        listaDeAlunos.add(aluno)
    }


    fun matricularAluno2(codigoAluno: Int, codigoCurso: Int) {
        var alunoAMatricular: Aluno? = null
        var cursoDoAlunoAMatricular: Curso? = null

        for (aluno in listaDeAlunos) {
            if (aluno.codAluno == codigoAluno) {
                alunoAMatricular = aluno
            }
        }
        for (curso in listaDeCursos) {
            if (curso.codDeCurso == codigoCurso) {
                cursoDoAlunoAMatricular = curso
            }
        }
        if (alunoAMatricular != null && cursoDoAlunoAMatricular != null) {
            if (cursoDoAlunoAMatricular.adicionarUmAluno(alunoAMatricular)) {
                val matricula = Matricula(alunoAMatricular, cursoDoAlunoAMatricular,"0")
                listaDeMatriculas.add(matricula)
            } else {
                println("Não há vagas disponíveis nesse curso.")
            }
        }else {
            println("Curso e/ou Aluno não Encontrados")

        }


}