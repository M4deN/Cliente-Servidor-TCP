# Aplicativo de Chat Multithread

Este aplicativo implementa um sistema de chat multithread simples. Consiste em um cliente e um servidor que se comunicam através de sockets para trocar mensagens.

## Funcionamento do Servidor

O arquivo `Atende_Cliente.java` contém a implementação do servidor. A classe `Atende_Cliente` estende a classe `Thread` e é responsável por lidar com as conexões de clientes individuais. Aqui está o funcionamento básico do servidor:

1. O servidor cria um socket e aguarda as conexões dos clientes.
2. Quando um cliente se conecta, é criada uma nova instância da classe `Atende_Cliente` para atender aquele cliente específico.
3. O objeto `Atende_Cliente` lê as mensagens enviadas pelo cliente e as encaminha para todos os outros clientes conectados.
4. O servidor continua ouvindo por novas mensagens até que o cliente envie a mensagem "exit" para encerrar a conexão.
5. Quando a conexão é encerrada, o objeto `Atende_Cliente` fecha os fluxos de entrada e saída e fecha o socket.

## Funcionamento do Cliente

O arquivo `Cliente.java` contém a implementação do cliente. Aqui está o funcionamento básico do cliente:

1. O cliente cria um socket e tenta se conectar ao servidor em um determinado endereço IP e porta.
2. Se a conexão for bem-sucedida, o cliente cria uma thread separada, chamada `Ouvir`, para ouvir as mensagens recebidas do servidor.
3. O cliente lê as mensagens digitadas pelo usuário no console e as envia para o servidor.
4. O cliente continua lendo e enviando mensagens até que o usuário digite a mensagem "exit" para encerrar a conexão.
5. Quando a conexão é encerrada, o cliente fecha o fluxo de saída e o socket.

## Executando o Aplicativo

Para executar o aplicativo de chat, siga as etapas abaixo:

1. Compile os arquivos Java usando o compilador Java. Certifique-se de ter o JDK (Java Development Kit) instalado no seu sistema.
   ```
   javac Atende_Cliente.java
   javac Cliente.java
   ```
2. Abra duas janelas do terminal ou prompt de comando.
3. Em uma janela, execute o seguinte comando para iniciar o servidor:
   ```
   java Chat.Cliente.Servidor.Atende_Cliente
   ```
4. Na outra janela, execute o seguinte comando para iniciar o cliente:
   ```
   java Cliente.Cliente
   ```
5. Agora você pode digitar mensagens no cliente e elas serão enviadas para o servidor e encaminhadas para todos os clientes conectados.

## Observações
- Certifique-se de executar o servidor antes de iniciar o cliente, caso contrário, o cliente não poderá se conectar.
- O aplicativo de chat implementado aqui é um exemplo simples e não possui recursos avançados de segurança, autenticação ou criptografia. É apenas uma demonstração de como a comunicação cliente-servidor pode ser estabelecida usando sockets em Java.
- Você pode executar várias instâncias do cliente em diferentes terminais ou em diferentes máquinas na mesma rede para testar a comunicação entre vários clientes.

Espero que isso esclareça o funcionamento do aplicativo de chat multithread em Java! Se você tiver mais alg

uma dúvida, sinta-se à vontade para perguntar.