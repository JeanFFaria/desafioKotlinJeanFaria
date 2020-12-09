package desafio

class DigitalHouseManager {
    val listaDeAlunos = mutableListOf<Aluno>()
    val listaDeProfessores = mutableListOf<Professor>()
    val listaDeCursos = mutableListOf<Curso>()
    val listaDeMatriculas = mutableListOf<Matricula>()

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

    fun matricularAlunoNaEscola(nome: String, sobrenome: String, codigoAluno: Int){
        val aluno = Aluno(nome = nome, sobrenome = sobrenome, codAluno = codigoAluno)
//        println("O aluno ${aluno.nome} ${aluno.sobrenome} foi matriculado a DH com o código $codigoAluno")
        listaDeAlunos.add(aluno)
    }

    fun pesquisarCurso(codigoCurso: Int): Curso? {
        for (curso in listaDeCursos){
            if (curso.codDeCurso == codigoCurso){
                return curso
            }
        }
        return null
    }

    fun pesquisarAluno(codigoAluno: Int): Aluno? {
        for (aluno in listaDeAlunos) {
            if (aluno.codAluno == codigoAluno) {
                return aluno
            }
        }
        return null
    }

    fun pesquisarProfessorAdjunto(codigoProfessorAdjunto: Int): Professor? {
        for (professorAdjunto in listaDeProfessores) {
            if (professorAdjunto.codDeProfessor == codigoProfessorAdjunto && professorAdjunto is ProfessorAdjunto) {
                return professorAdjunto
            }
        }
        return null
    }

    fun pesquisarProfessorTitular(codigoProfessorTitular: Int): Professor? {
        for (professorTitular in listaDeProfessores) {
            if (professorTitular.codDeProfessor == codigoProfessorTitular && professorTitular is ProfessorTitular) {
                return professorTitular
            }
        }
        return null
    }

    fun matricularAlunoNoCurso(codigoAluno: Int, codigoCurso: Int) {
        val alunoAMatricular = pesquisarAluno(codigoAluno)
        val cursoAMatricular = pesquisarCurso(codigoCurso)

        if (alunoAMatricular != null && cursoAMatricular != null) {
           if (cursoAMatricular.adicionarUmAluno(alunoAMatricular)) {
                val matricula = Matricula(alunoAMatricular, cursoAMatricular, "00/00/0000")
                listaDeMatriculas.add(matricula)
                println("O aluno ${alunoAMatricular.nome} foi matriculado no Curso ${cursoAMatricular.nomeCurso} em ${matricula.dataDeMatricula}")
            } else {
                println("O aluno ${alunoAMatricular.nome} não foi matriculado no Curso ${cursoAMatricular.nomeCurso}, pois não há vagas disponiveis no curso.")
            } } else{
            println("Curso e/ou Aluno não cadastrados")
        }
    }

    fun alocarProfessores(codigoCurso: Int,codigoProfessorTitular: Int, codigoProfessorAdjunto : Int){

        val cursoAlocacao = pesquisarCurso(codigoCurso)
        val professorTitularAlocacao = pesquisarProfessorTitular(codigoProfessorTitular)
        val professorAdjuntoAlocacao = pesquisarProfessorAdjunto(codigoProfessorAdjunto)

        if(cursoAlocacao != null && professorAdjuntoAlocacao != null && professorTitularAlocacao != null){

            cursoAlocacao.professorAdjunto = professorAdjuntoAlocacao as ProfessorAdjunto
            cursoAlocacao.professorTitular = professorTitularAlocacao as ProfessorTitular

            println("O Professor Titular ${professorTitularAlocacao.nome} e o Professor Adjunto ${professorAdjuntoAlocacao.nome} foram alocados ao Curso ${cursoAlocacao.nomeCurso}")

        }else{
            println("Não foi possivel realizar a alocacao")
        }

    }

}