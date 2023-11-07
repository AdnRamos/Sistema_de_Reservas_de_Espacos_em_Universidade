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
      class Treinamentos {
          -id: Long
          -descricao: String
          -espacosEquipamentosAssociados: String
      }
      class CertificacoesDeTreinamento {
          -usuarioID: Long
          -treinamentoID: Long
          -dataObtencao: dateTime
          -dataValidade: dateTime 
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
      Usuarios "1" -- "N" CertificacoesDeTreinamento : possui >
      Treinamentos "1" -- "N" CertificacoesDeTreinamento : valida >
      Usuarios "1" -- "N" Reservas : realiza >
      Espacos "1" -- "N" Reservas : reservado_por >
      Espacos "1" -- "N" Equipamentos : contem >
      Espacos "1" -- "N" RestricoesDeHorario : possui >
```

## Diagrama ER

```mermaid
erDiagram
    DEPARTAMENTOS ||--o{ ESPACOS : contem
    USUARIOS ||--o{ CERTIFICACOES-DE-TREINAMENTO : possui
    USUARIOS ||--o{ RESERVAS : realiza
    TREINAMENTOS ||--o{ CERTIFICACOES-DE-TREINAMENTO : valida
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

    TREINAMENTOS {
        Long id PK "Identificador único"
        String descricao "Descrição"
        String espacosEquipamentosAssociados "Espaços/equipamentos associados"
    }

    CERTIFICACOES-DE-TREINAMENTO {
        Long usuarioID FK "ID do usuário"
        Long treinamentoID FK "ID do treinamento"
        dateTime dataObtencao "Data de obtenção"
        dateTime dataValidade "Data de validade"
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


## University Space Reservation System

The goal is to enable simple and practical management and reservation of spaces such as classrooms, laboratories, auditoriums, and equipment within a university. The system is capable of managing departments, users with different roles, training, equipment, time restrictions, scheduling conflicts, feedback, and reports.

### UML Class Diagram

```mermaid

classDiagram
      class Departments {
          -id: Long
          -name: String
          -manager: String
          -contact: String
      }
      class Spaces {
          -id: Long
          -name: String
          -type: String
          -capacity: int
          -availableEquipment: String
          -photos: String
          -availableHours: String
          -departmentID: Long
      }
      class Users {
          -id: Long
          -name: String
          -email: String
          -type: String
      }
      class Reservations {
          -id: Long
          -userID: Long
          -spaceID: Long
          -datetime startTime
          -datetime endTime
          -purpose: String
          -status: String
      }
      class Equipment {
          -id: Long
          -name: String 
          -description: String
          -availableQuantity: int
          -status: String
      }
      class Trainings {
          -id: Long
          -description: String
          -associatedSpacesEquipment: String
      }
      class TrainingCertifications {
          -userID: Long
          -trainingID: Long
          -acquisitionDate: dateTime
          -validityDate: dateTime
      }
      class TimeRestrictions {
          -spaceID: Long
          -dayOfWeek: String
          -startTime: dateTime
          -endTime: dateTime
          -reason: String
      }

      %% Relationships
      Departments "1" -- "N" Spaces : contains >
      Users "1" -- "N" TrainingCertifications : owns >
      Trainings "1" -- "N" TrainingCertifications : validates >
      Users "1" -- "N" Reservations : makes >
      Spaces "1" -- "N" Reservations : reserved_by >
      Spaces "1" -- "N" Equipment : contains >
      Spaces "1" -- "N" TimeRestrictions : has >

```
### ER Diagram

```mermaid
erDiagram
    DEPARTMENTS ||--o{ SPACES : contains
    USERS ||--o{ TRAINING-CERTIFICATIONS : owns
    USERS ||--o{ RESERVATIONS : makes
    TRAININGS ||--o{ TRAINING-CERTIFICATIONS : validates
    SPACES ||--o{ RESERVATIONS : reserved_by
    SPACES ||--o{ EQUIPMENT : contains
    SPACES ||--o{ TIME-RESTRICTIONS : has

    DEPARTMENTS {
        Long id PK "Unique identifier"
        String name "Department name"
        String manager "Manager"
        String contact "Contact information"
    }

    SPACES {
        Long id PK "Unique identifier"
        String name "Name"
        String type "Type (classroom, laboratory, auditorium)"
        int capacity "Capacity"
        String availableEquipment "Available equipment"
        String photos "Photos"
        String availableHours "Available hours"
        Long departmentID FK "Responsible department"
        String specificRules "Specific rules"
    }

    USERS {
        Long id PK "Unique identifier"
        String name "Name"
        String email "Email"
        String type "Type (professor, student, etc.)"
    }

    RESERVATIONS {
        Long id PK "Unique identifier"
        Long userID FK "User ID"
        Long spaceID FK "Space ID"
        dateTime startTime "Start date/time"
        dateTime endTime "End date/time"
        String purpose "Purpose"
        String status "Status"
    }

    EQUIPMENT {
        Long id PK "Unique identifier"
        String name "Name"
        String description "Description"
        int availableQuantity "Available quantity"
        String status "Status"
    }

    TRAININGS {
        Long id PK "Unique identifier"
        String description "Description"
        String associatedSpacesEquipment "Associated spaces/equipment"
    }

    TRAINING-CERTIFICATIONS {
        Long userID FK "User ID"
        Long trainingID FK "Training ID"
        dateTime acquisitionDate "Acquisition date"
        dateTime validityDate "Validity date"
    }

    TIME-RESTRICTIONS {
        Long spaceID FK "Space ID"
        String dayOfWeek "Day of the week"
        dateTime startTime "Start time"
        dateTime endTime "End time"
        String reason "Reason"
    }
```

### Key System Functions:

- **User Management:** Adding and configuring new users, defining roles and permissions.

- **Department Management:** Creating and maintaining departments, associating responsible parties and spaces.

- **Space and Equipment Management:** Updating spaces and equipment, maintaining availability and specific rules.

- **Reservation Management:** Overseeing the reservation process, resolving scheduling conflicts and enforcing penalties.

- **Space Reservation:** Authorized users can make reservations, with the system automatically checking for availability.

- **Authorization Management:** Professors and administrative staff can authorize other users to reserve specific spaces.

- **Dynamic Equipment Allocation:** Users can request equipment when making a reservation.

- **Usage History:** Detailed record of all reservations and collection of feedback.

- **Analysis and Reports:** Generation of reports on space utilization and equipment condition.

- **Penalty System:** Imposing penalties for users who make reservations but do not use the spaces.

- **Integration with Academic Calendar:** Automatic adjustment of space availability based on the academic calendar.

