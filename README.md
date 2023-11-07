Select a language: [Português](#sistema-de-reservas-de-espaços-em-universidade) | [English](#university-space-reservation-system)

## Sistema de Reservas de Espaços em Universidade

O objetivo é permitir a gestão simples e pratica de reserva de espaços, como salas, laboratórios, auditórios e equipamentos, em uma universidade. O sistema deve é capaz de gerenciar departamentos, usuários com diferentes papéis, treinamentos, equipamentos, restrições de horário, conflitos de agendamento, feedbacks e relatórios.


## Diagrama de Classes UML

```mermaid

classDiagram
      class Departamentos {
          -int id
          -string nome
          -string responsavel
          -string contato
      }
      class Espacos {
          -int id
          -string nome
          -string tipo
          -int capacidade
          -string equipamentosDisponiveis
          -string fotos
          -string horariosDisponiveis
          -int departamentoID
      }
      class Usuarios {
          -int id
          -string nome
          -string email
          -string tipo
      }
      class Reservas {
          -int id
          -int usuarioID
          -int espacoID
          -datetime dataHoraInicio
          -datetime dataHoraTermino
          -string finalidade
          -string status
      }
      class Equipamentos {
          -int id
          -string nome
          -string descricao
          -int quantidadeDisponivel
          -string status
      }
      class Treinamentos {
          -int id
          -string descricao
          -string espacosEquipamentosAssociados
      }
      class CertificacoesDeTreinamento {
          -int usuarioID
          -int treinamentoID
          -date dataObtencao
          -date dataValidade
      }
      class RestricoesDeHorario {
          -int espacoID
          -string diaDaSemana
          -time horarioInicio
          -time horarioTermino
          -string motivo
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
        int id PK "Identificador único"
        string nome "Nome do departamento"
        string responsavel "Responsável"
        string contato "Contato"
    }

    ESPACOS {
        int id PK "Identificador único"
        string nome "Nome"
        string tipo "Tipo (sala, laboratório, auditório)"
        int capacidade "Capacidade"
        string equipamentosDisponiveis "Equipamentos disponíveis"
        string fotos "Fotos"
        string horariosDisponiveis "Horários disponíveis"
        int departamentoID FK "Departamento responsável"
        string regrasEspecificas "Regras específicas"
    }

    USUARIOS {
        int id PK "Identificador único"
        string nome "Nome"
        string email "Email"
        string tipo "Tipo (professor, aluno, etc.)"
    }

    RESERVAS {
        int id PK "Identificador único"
        int usuarioID FK "ID do usuário"
        int espacoID FK "ID do espaço"
        dateTime dataHoraInicio "Data/hora de início"
        dateTime dataHoraTermino "Data/hora de término"
        string finalidade "Finalidade"
        string status "Status"
    }

    EQUIPAMENTOS {
        int id PK "Identificador único"
        string nome "Nome"
        string descricao "Descrição"
        int quantidadeDisponivel "Quantidade disponível"
        string status "Status"
    }

    TREINAMENTOS {
        int id PK "Identificador único"
        string descricao "Descrição"
        string espacosEquipamentosAssociados "Espaços/equipamentos associados"
    }

    CERTIFICACOES-DE-TREINAMENTO {
        int usuarioID FK "ID do usuário"
        int treinamentoID FK "ID do treinamento"
        date dataObtencao "Data de obtenção"
        date dataValidade "Data de validade"
    }

    RESTRICOES-DE-HORARIO {
        int espacoID FK "ID do espaço"
        string diaDaSemana "Dia da semana"
        time horarioInicio "Horário de início"
        time horarioTermino "Horário de término"
        string motivo "Motivo"
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
          -int id
          -string name
          -string manager
          -string contact
      }
      class Spaces {
          -int id
          -string name
          -string type
          -int capacity
          -string availableEquipment
          -string photos
          -string availableHours
          -int departmentID
      }
      class Users {
          -int id
          -string name
          -string email
          -string type
      }
      class Reservations {
          -int id
          -int userID
          -int spaceID
          -datetime startTime
          -datetime endTime
          -string purpose
          -string status
      }
      class Equipment {
          -int id
          -string name
          -string description
          -int availableQuantity
          -string status
      }
      class Trainings {
          -int id
          -string description
          -string associatedSpacesEquipment
      }
      class TrainingCertifications {
          -int userID
          -int trainingID
          -date acquisitionDate
          -date validityDate
      }
      class TimeRestrictions {
          -int spaceID
          -string dayOfWeek
          -time startTime
          -time endTime
          -string reason
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
        int id PK "Unique identifier"
        string name "Department name"
        string manager "Manager"
        string contact "Contact information"
    }

    SPACES {
        int id PK "Unique identifier"
        string name "Name"
        string type "Type (classroom, laboratory, auditorium)"
        int capacity "Capacity"
        string availableEquipment "Available equipment"
        string photos "Photos"
        string availableHours "Available hours"
        int departmentID FK "Responsible department"
        string specificRules "Specific rules"
    }

    USERS {
        int id PK "Unique identifier"
        string name "Name"
        string email "Email"
        string type "Type (professor, student, etc.)"
    }

    RESERVATIONS {
        int id PK "Unique identifier"
        int userID FK "User ID"
        int spaceID FK "Space ID"
        dateTime startTime "Start date/time"
        dateTime endTime "End date/time"
        string purpose "Purpose"
        string status "Status"
    }

    EQUIPMENT {
        int id PK "Unique identifier"
        string name "Name"
        string description "Description"
        int availableQuantity "Available quantity"
        string status "Status"
    }

    TRAININGS {
        int id PK "Unique identifier"
        string description "Description"
        string associatedSpacesEquipment "Associated spaces/equipment"
    }

    TRAINING-CERTIFICATIONS {
        int userID FK "User ID"
        int trainingID FK "Training ID"
        date acquisitionDate "Acquisition date"
        date validityDate "Validity date"
    }

    TIME-RESTRICTIONS {
        int spaceID FK "Space ID"
        string dayOfWeek "Day of the week"
        time startTime "Start time"
        time endTime "End time"
        string reason "Reason"
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

