import java.util.Scanner;

import src.entities.AlunoEntity;
import src.services.AlunoService;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static AlunoService alunoService = AlunoService.getInstance();

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
                    "1 - Cadastrar Aluno\n2 - Pesquisar Aluno\n3 - Alterar Aluno\n4 - Excluir Aluno\n5 - Sair");

            opcao = readInt();

            int matricula;
            String nome;
            AlunoEntity aluno;

            switch (opcao) {
                case 1:
                    System.out.println("Informe a matrícula do aluno:");
                    matricula = readInt();

                    if (matricula > 0) {
                        System.out.println("Informe o nome do aluno:");
                        nome = scanner.nextLine();

                        boolean ativo = true;

                        if (alunoService.insert(matricula, nome, ativo) == true) {
                            System.out.println("Aluno inserido com sucesso");
                        } else {
                            System.out.println("Falha ao tentar inserir o aluno");
                        }
                    } else {
                        System.out.println("Matrícula inválida, favor informar somente números inteiros positivos");
                    }

                    break;
                case 2:
                    System.out.println("Informe a matrícula do aluno:");
                    matricula = readInt();

                    aluno = alunoService.getByMatricula(matricula);

                    if (aluno != null) {
                        System.out.println(aluno);
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;
                case 3:
                    System.out.println("Informe a matrícula do aluno:");
                    matricula = readInt();

                    aluno = alunoService.getByMatricula(matricula);

                    if (aluno != null) {
                        System.out.println("Informe o novo nome do aluno:");
                        nome = scanner.nextLine();

                        System.out.println("Informe se o aluno está ativo (S/N):");
                        boolean ativo = readAtivo();

                        if (alunoService.update(matricula, nome, ativo) == true) {
                            System.out.println("Aluno alterado com sucesso");
                        } else {
                            System.out.println("Falha ao tentar alterar o aluno");
                        }
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;
                case 4:
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
                case 5:
                    System.out.println("Finalizando o programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 5);

        // insertAluno(10, "Maria", true);
        // insertAluno(20, "Pedro", false);
        // insertAluno(30, "João", true);
        // insertAluno(40, "Antônio", false);
        // insertAluno(50, "José", true);
        // insertAluno(60, "Facebookison", false);

        // System.out.println(alunoService.size());

        // System.out.println(alunoService.getByMatricula(40));
        // System.out.println(alunoService.getByMatricula(70));

        // AlunoEntity a1 = alunoService.getByMatricula(50);

        // System.out.println(a1.getMatricula());
        // System.out.println(a1.getNome());
        // System.out.println(a1.isAtivo());

        // a1.setNome("José Antônio");
        // a1.setAtivo(false);

        // alunoService.update(a1);

        // AlunoEntity a2 = alunoService.getByMatricula(50);

        // System.out.println(a2.getMatricula());
        // System.out.println(a2.getNome());
        // System.out.println(a2.isAtivo());

        // alunoService.delete(a2);

        // System.out.println(alunoService.getByMatricula(50));

        // AlunoEntity a2 = a1;

        // a2.setMatricula(10);

        // a2 = null;

        // System.out.println(a1.getMatricula());

        // a1 = null;

        // AlunoEntity a3 = AlunoEntity.getInstance();

        // System.out.println(a3.getMatricula());

        // a3 = null;

        // AlunoEntity a4 = AlunoEntity.getInstance();

        // a4.setMatricula(20);
        // a4.setNome("Maria");
        // a4.setAtivo(true);

        // a4 = null;

        // AlunoEntity a5 = AlunoEntity.getInstance();

        // a5.setNome("Pedro");

        // System.out.println(a5.getMatricula());
        // System.out.println(a5.getNome());
        // System.out.println(a5.isAtivo());

        // a5 = null;
    }

}
