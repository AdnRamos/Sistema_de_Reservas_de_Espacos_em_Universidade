# Sistema Reservas de Espaços em Universidade

O objetivo é permitir a gestão simples e pratica de reserva de espaços, como salas, laboratórios, auditórios e equipamentos, em uma universidade. O sistema deve é capaz de gerenciar departamentos, usuários com diferentes papéis, treinamentos, equipamentos, restrições de horário, conflitos de agendamento, feedbacks e relatórios.


## Diagrama de Classes UML

Abaixo está o diagrama de classes UML do sistema:

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

