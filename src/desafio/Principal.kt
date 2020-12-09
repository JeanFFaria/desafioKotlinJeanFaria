package desafio

fun main() {

    val digitalHouse = DigitalHouseManager()

    digitalHouse.registrarProfessorTitular("Felipe","Andrade",1,"TI")
    digitalHouse.registrarProfessorTitular("Luis","Fernando",2,"TI")

    digitalHouse.registrarProfessorAdjunto("Cláudio","Silva",3,0)
    digitalHouse.registrarProfessorAdjunto("Pedro","Costa",4,0)

    digitalHouse.registrarCurso("Full Stack",20001,3)
    digitalHouse.registrarCurso("Android",20002,2)

    digitalHouse.matricularAlunoNaEscola("Jean","Faria",1)
    digitalHouse.matricularAlunoNaEscola("João","Pedro",2)
    digitalHouse.matricularAlunoNaEscola("Carol","Ribeiro",3)

    digitalHouse.matricularAlunoNoCurso(1,20001)
    digitalHouse.matricularAlunoNoCurso(2,20001)

    digitalHouse.matricularAlunoNoCurso(1,20002)
    digitalHouse.matricularAlunoNoCurso(2,20002)
    digitalHouse.matricularAlunoNoCurso(3,20002)








}