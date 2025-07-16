📄 Sobre o Projeto
Este é um programa em Java simples e eficiente para processar dados de arquivos de texto (TXT) e gerar um arquivo CSV formatado. Ele lê informações sobre produtos (nome, preço e quantidade vendida) de um TXT de entrada, calcula o valor total de vendas para cada produto e exporta esses dados para um novo arquivo CSV.

O objetivo é fornecer uma ferramenta prática para transformar dados brutos de texto em um formato tabular fácil de analisar em softwares como o Microsoft Excel ou Google Sheets.

✨ Funcionalidades
Leitura de TXT: Processa arquivos de texto (.txt) com dados de produtos.

Extração de Dados: Identifica e separa o nome do produto, seu preço e a quantidade vendida em cada linha do TXT.

Cálculo de Vendas: Calcula o valor total de vendas para cada produto (preço * quantidade).

Criação de Pasta de Saída: Automaticamente cria uma pasta chamada out no mesmo diretório do arquivo TXT de entrada para organizar os resultados.

Geração de CSV: Cria um arquivo CSV (summary.csv) dentro da pasta out, contendo o nome do produto e o valor total de vendas, formatado para fácil leitura em planilhas.

Tratamento de Erros: Inclui tratamento básico para linhas mal formatadas ou erros de leitura/escrita.

🚀 Como Usar
Pré-requisitos
Java Development Kit (JDK) 11 ou superior instalado.

IDE Java (como Eclipse, IntelliJ IDEA ou VS Code com extensões Java).

Configuração e Execução
Clone o Repositório (ou baixe os arquivos diretamente):

Bash

git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
cd SEU_REPOSITORIO
(Substitua SEU_USUARIO e SEU_REPOSITORIO pelos seus dados)

Abra o Projeto na sua IDE:
Importe o projeto para sua IDE Java favorita.

Crie seu Arquivo de Entrada TXT:
No mesmo diretório onde você vai rodar o programa (ou em um caminho que você possa informar), crie um arquivo .txt (por exemplo, produtos.txt).
Cada linha do arquivo deve seguir o formato NomeDoProduto,Preco,Quantidade.

Exemplo de produtos.txt:

Monitor Gamer,1500.00,2
Teclado Mecanico,300.50,5
Mouse Sem Fio,120.00,10
Execute o Programa:

Abra a classe Program.java (localizada em src/application/Program.java ou similar).

Execute o método main.

Informe o Caminho:
O console pedirá para você "Digite o caminho COMPLETO do arquivo TXT de entrada". Insira o caminho completo para o seu arquivo produtos.txt (ex: C:\caminho\para\seu\projeto\produtos.txt ou /home/usuario/seu_projeto/produtos.txt).

Verifique a Saída:
Após a execução bem-sucedida, uma pasta chamada out será criada no mesmo diretório do seu arquivo TXT de entrada. Dentro dela, você encontrará o arquivo summary.csv com os resultados.

Exemplo de summary.csv gerado:

Snippet de código

Produto,ValorTotalVendido
Monitor Gamer,3000.00
Teclado Mecanico,1502.50
Mouse Sem Fio,1200.00
⚠️ Considerações
Certifique-se de que o formato do TXT de entrada esteja correto (campos separados por vírgula e na ordem Nome,Preco,Quantidade).

O cálculo do valor total vendido considera Preço * Quantidade.

O arquivo CSV de saída utiliza a vírgula (,) como delimitador. Se o seu Excel não separar as colunas automaticamente, você pode precisar usar a função "Obter Dados" ou "De Texto/CSV" no Excel e especificar a vírgula como delimitador.
