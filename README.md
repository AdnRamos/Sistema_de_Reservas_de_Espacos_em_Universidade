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
