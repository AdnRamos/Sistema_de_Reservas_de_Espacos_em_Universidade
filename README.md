Select a language: [Português](#sistema-de-reservas-de-espaços-em-universidade) | [English](#university-space-reservation-system)

## Sistema de Reservas de Espaços em Universidade

O objetivo é permitir a gestão simples e pratica de reserva de espaços, como salas, laboratórios, auditórios e equipamentos, em uma universidade. O sistema deve é capaz de gerenciar departamentos, usuários com diferentes papéis, treinamentos, equipamentos, restrições de horário, conflitos de agendamento, feedbacks e relatórios.


## Diagrama de Classes UML

```mermaid

classDiagram
      class Departamentos {
          -id: Long
          -nome: String 
          -responsavel: String
          -contato: String
      }
      class Espacos {
          -id: Long
          -nome: String
          -tipo: String
          -capacidade: int
          -equipamentosDisponiveis: String
          -fotos: String
          -horariosDisponiveis: String
          -departamentoID: Long
      }
      class Usuarios {
          -id: Long
          -nome: String
          -email: String
          -tipo: String
      }
      class Reservas {
          -id: Long
          -usuarioID: int
          -espacoID: int 
          -dataHoraInicio: dateTime 
          -dataHoraTermino: dateTime 
          -finalidade: String
          -status: String
      }
      class Equipamentos {
          -id: Long
          -nome: String
          -descricao: String
          -quantidadeDisponivel: int
          -status: String
      }


      class RestricoesDeHorario {
          -espacoID: Long
          -diaDaSemana: String 
          -horarioInicio: dateTime 
          -horarioTermino: dateTime
          -motivo: String 
      }

      %% Relationships
      Departamentos "1" -- "N" Espacos : contem >
      Usuarios "1" -- "N" Reservas : realiza >
      Penalidade "1" -- "1" Reservas : contem >
      Penalidade "N" -- "1" Usuarios : possui >
      Espacos "1" -- "N" Reservas : reservado_por >
      Espacos "1" -- "N" Equipamentos : contem >
      Espacos "1" -- "N" RestricoesDeHorario : possui >
```

## Diagrama ER

```mermaid
erDiagram
    DEPARTAMENTOS ||--o{ ESPACOS : contem
    USUARIOS ||--o{ RESERVAS : realiza
    PENALIDADE |o--o| RESERVAS : contem
    PENALIDADE }o--o|  USUARIOS : possui

    ESPACOS ||--o{ RESERVAS : reservado_por
    ESPACOS ||--o{ EQUIPAMENTOS : contem
    ESPACOS ||--o{ RESTRICOES-DE-HORARIO : possui

    DEPARTAMENTOS {
        Long id PK "Identificador único"
        String nome "Nome do departamento"
        String responsavel "Responsável"
        String contato "Contato"
    }

    ESPACOS {
        Long id PK "Identificador único"
        String nome "Nome"
        String tipo "Tipo (sala, laboratório, auditório)"
        int capacidade "Capacidade"
        String equipamentosDisponiveis "Equipamentos disponíveis"
        String fotos "Fotos"
        String horariosDisponiveis "Horários disponíveis"
        Long departamentoID FK "Departamento responsável"
        String regrasEspecificas "Regras específicas"
    }

    USUARIOS {
        Long id PK "Identificador único"
        String nome "Nome"
        String email "Email"
        String tipo "Tipo (professor, aluno, etc.)"
    }

    RESERVAS {
        Long id PK "Identificador único"
        Long usuarioID FK "ID do usuário"
        Long espacoID FK "ID do espaço"
        dateTime dataHoraInicio "Data/hora de início"
        dateTime dataHoraTermino "Data/hora de término"
        String finalidade "Finalidade"
        String status "Status"
    }

    EQUIPAMENTOS {
        Long id PK "Identificador único"
        String nome "Nome"
        String descricao "Descrição"
        int quantidadeDisponivel "Quantidade disponível"
        String status "Status"
    }

    RESTRICOES-DE-HORARIO {
        Long espacoID FK "ID do espaço"
        String diaDaSemana "Dia da semana"
        dateTime horarioInicio "Horário de início"
        dateTIme horarioTermino "Horário de término"
        String motivo "Motivo"
    }

```
## Principais Funções do Sistema:

- **Gestão de Usuários:** Adição e configuração de novos usuários, definição de papéis e permissões.

- **Gestão de Departamentos:** Criação e manutenção de departamentos, associação de responsáveis e espaços.

- **Gerenciamento de Espaços e Equipamentos:** Atualização de espaços e equipamentos, manutenção de disponibilidade e regras.

- **Gestão de Reservas:** Supervisão do processo de reserva, resolução de conflitos e aplicação de penalidades.

- **Reserva de Espaços:** Possibilidade de usuários autorizados realizarem reservas, com verificação automática de disponibilidade.

- **Gestão de Autorizações:** Capacidade de professores e funcionários administrativos autorizarem reservas a outros usuários.

- **Alocação Dinâmica de Equipamentos:** Usuários podem solicitar equipamentos ao reservar espaços.

- **Histórico de Utilização:** Registro detalhado das reservas e coleta de feedback.

- **Análise e Relatórios:** Geração de relatórios sobre utilização dos espaços e condição dos equipamentos.

- **Sistema de Penalidades:** Imposição de penalidades para usuários que não utilizam espaços reservados.

- **Integração com Calendário Acadêmico:** Disponibilidade de espaços ajustada automaticamente com base no calendário acadêmico.
