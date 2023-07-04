import java.util.Scanner;

import src.entities.AlunoEntity;
import src.entities.CursoEntity;
import src.services.AlunoService;
import src.services.CursoService;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static AlunoService alunoService = AlunoService.getInstance();
    private static CursoService cursoService = CursoService.getInstance();

    public static int readInt() {
        boolean valorInvalido = true;
        int result = 0;

        do {
            try {
                result = Integer.parseInt(scanner.nextLine());

                valorInvalido = false;
            } catch (Exception ex) {
                System.out.println("Valor inválido");
            }
        } while (valorInvalido == true);

        return result;
    }

    public static boolean readAtivo() {
        boolean valorInvalido = true;
        boolean result = false;
        String leitura;

        do {
            leitura = scanner.nextLine();

            if ("S".equals(leitura) || "N".equals(leitura)) {
                result = "S".equals(leitura) ? true : false;

                valorInvalido = false;
            } else {
                System.out.println("Valor inválido, favor informar somente \"S\" ou \"N\"");
            }
        } while (valorInvalido == true);

        return result;
    }

    public static void main(String[] args) {
        int opcao = 0;

        do {
            System.out.println(
                    "1 - Cadastrar Curso\n2 - Pesquisar Curso\n3 - Alterar Curso\n4 - Excluir Curso\n5 - Cadastrar Aluno\n6 - Pesquisar Aluno\n7 - Alterar Aluno\n8 - Excluir Aluno\n9 - Sair");

            opcao = readInt();

            int matricula;
            int idCurso;
            String nome;
            String descricao;
            AlunoEntity aluno;
            CursoEntity curso;

            switch (opcao) {
                case 1:
                    System.out.println("Informe o ID do curso:");
                    idCurso = readInt();

                    if (idCurso > 0) {
                        System.out.println("Informe o nome do curso:");
                        nome = scanner.nextLine();

                        System.out.println("Informe a descrição do curso:");
                        descricao = scanner.nextLine();

                        if (cursoService.insert(idCurso, nome, descricao) == true) {
                            System.out.println("Curso inserido com sucesso");
                        } else {
                            System.out.println("Falha ao tentar inserir o curso");
                        }
                    } else {
                        System.out.println("ID inválido, favor informar somente números inteiros positivos");
                    }
                    break;
                case 2:
                    System.out.println("Informe o ID do curso:");
                    idCurso = readInt();

                    curso = cursoService.getByID(idCurso);

                    if (curso != null) {
                        System.out.println(curso);
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
                case 3:
                    System.out.println("Informe o ID do curso:");
                    idCurso = readInt();

                    curso = cursoService.getByID(idCurso);

                    if (curso != null) {
                        System.out.println("Informe o novo nome do curso:");
                        nome = scanner.nextLine();

                        System.out.println("Informe a nova descrição do curso:");
                        descricao = scanner.nextLine();

                        if (cursoService.update(idCurso, nome, descricao) == true) {
                            System.out.println("Curso alterado com sucesso");
                        } else {
                            System.out.println("Falha ao tentar alterar o curso");
                        }
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
                case 4:
                    System.out.println("Informe o ID do curso:");
                    idCurso = readInt();

                    curso = cursoService.getByID(idCurso);

                    if (curso != null) {
                        if (cursoService.delete(idCurso) == true) {
                            System.out.println("Curso removido com sucesso");
                        } else {
                            System.out.println("Falha ao tentar remover o curso");
                        }
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
                case 5:
                    System.out.println("Informe o ID do curso do aluno:");
                    idCurso = readInt();

                    curso = cursoService.getByID(idCurso);

                    if (curso != null) {
                        System.out.println("Informe a matrícula do aluno:");
                        matricula = readInt();

                        if (matricula > 0) {
                            System.out.println("Informe o nome do aluno:");
                            nome = scanner.nextLine();

                            boolean ativo = true;

                            if (alunoService.insert(matricula, nome, ativo, curso) == true) {
                                curso.insertAluno(alunoService.getByMatricula(matricula));

                                System.out.println("Aluno inserido com sucesso");
                            } else {
                                System.out.println("Falha ao tentar inserir o aluno");
                            }
                        } else {
                            System.out.println("Matrícula inválida, favor informar somente números inteiros positivos");
                        }
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
                case 6:
                    System.out.println("Informe a matrícula do aluno:");
                    matricula = readInt();

                    aluno = alunoService.getByMatricula(matricula);

                    if (aluno != null) {
                        System.out.println(aluno);
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;
                case 7:
                    System.out.println("Informe a matrícula do aluno:");
                    matricula = readInt();

                    aluno = alunoService.getByMatricula(matricula);

                    if (aluno != null) {
                        System.out.println("Informe o ID do novo curso do aluno:");
                        idCurso = readInt();

                        curso = cursoService.getByID(idCurso);

                        if (curso != null) {
                            System.out.println("Informe o novo nome do aluno:");
                            nome = scanner.nextLine();

                            System.out.println("Informe se o aluno está ativo (S/N):");
                            boolean ativo = readAtivo();

                            if (alunoService.update(matricula, nome, ativo, curso) == true) {
                                System.out.println("Aluno alterado com sucesso");
                            } else {
                                System.out.println("Falha ao tentar alterar o aluno");
                            }
                        } else {
                            System.out.println("Curso não encontrado");
                        }
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;
                case 8:
                    System.out.println("Informe a matrícula do aluno:");
                    matricula = readInt();

                    aluno = alunoService.getByMatricula(matricula);

                    if (aluno != null) {
                        if (alunoService.delete(matricula) == true) {
                            System.out.println("Aluno removido com sucesso");
                        } else {
                            System.out.println("Falha ao tentar remover o aluno");
                        }
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;
                case 9:
                    System.out.println("Finalizando o programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 9);
    }

}
