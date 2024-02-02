## Sistema de Reservas de Espaços em Universidade

O objetivo é permitir a gestão simples e pratica de reserva de espaços, como salas, laboratórios, auditórios e equipamentos, em uma universidade. O sistema deve é capaz de gerenciar departamentos, usuários com diferentes papéis, treinamentos, equipamentos, restrições de horário, conflitos de agendamento, feedbacks e relatórios.


## Diagrama ER

```mermaid
erDiagram
    DEPARTAMENTOS ||--o{ ESPACOS : contem
    USUARIOS ||--o{ RESERVAS : realiza
    PENALIDADES |o--o| RESERVAS : contem
    ESPACOS ||--o{ RESERVAS : contem
    ESPACOS ||--o{ FOTOS : contem
    ESPACOS ||--o{ EQUIPAMENTOS : contem
    ESPACOS ||--o{ DISPONIBILIDADES : possui
    DEPARTAMENTOS {
        BIGINT id PK "Identificador único"
        VARCHAR(200) nome "Nome do departamento"
        VARCHAR(200) responsavel "Responsável"
        VARCHAR(11) contato "Contato"
    }
      PENALIDADES {
        BIGINT id PK "Identificador único"
        BIGINT id_usuario FK "Identificador do usuário que recebeu penalidade"
        BIGINT id_espaco FK "Espaço reservadod que gerou a multa"
        VARCHAR(200) justificativa "Motivo da penalidade"
      }
    ESPACOS {
        BIGINT id PK "Identificador único"
        VARCHAR(200) nome "Nome"
        String tipo "Tipo (sala, laboratório, auditório)"
        INT capacidade "Capacidade"
        BIGINT departamentoID FK "Departamento responsável"
        VARCHAR(200) regrasEspecificas "Regras específicas"
    }
    FOTOS{
       BIGINT id PK "Identificador único"
       BIGINT id_espaco FK "Identificador do espaço"
       VARCHAR(200) url "Url da imagem"
    }
    USUARIOS {
        BIGINT id PK "Identificador único"
        VARCHAR(200) nome "Nome"
        VARCHAR(50) email "Email"
        VARCHAR(11) contato "telefone"
        ENUM tipo "Tipo (professor, aluno)"
    }
    RESERVAS {
        BIGINT id PK "Identificador único"
        BIGINT usuarioID FK "ID do usuário"
        BIGINT espacoID FK "ID do espaço"
        DATETIME dataHoraInicio "Data/hora de início"
        DATETIME dataHoraTermino "Data/hora de término"
        VARCHAR(200) finalidade "Finalidade"
        ENUM status "Status (reservado,finalizado,penalizado,cancelado)"
    }
    EQUIPAMENTOS {
        BIGINT id PK "Identificador único"
        BIGINT espacoID FK "ID do espaço"
        VARCHAR(200) nome "Nome"
        VARCHAR(200) descricao "Descrição"
        INT quantidadeDisponivel "Quantidade disponível"
        VARCHAR(200) status "Status"
    }
    DISPONIBILIDADES {
        BIGINT id PK "Identificador único"
        BIGINT espacoID FK "ID do espaço"
        VARCHAR(200) diaDaSemana "Dia da semana"
        DATETIME horarioInicio "Horário de início"
        DATETIME horarioTermino "Horário de término"
        VARCHAR(200) motivo "Motivo"
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
