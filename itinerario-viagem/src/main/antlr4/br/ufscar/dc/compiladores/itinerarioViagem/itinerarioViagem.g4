grammar itinerarioViagem;
/*----------------------------- ESTRUTURA LÉXICA ----------------------- */
// Palavras-chave
VIAGEM: 'viagem';
HOSPEDAGEM: 'hospedagem';
TRANSPORTE: 'transporte';
ATIVIDADES: 'atividades';
TIPO: 'tipo';
NOME: 'nome';
CHECK_IN: 'check_in';
CHECK_OUT: 'check_out';
DATA_INICIO: 'data_inicio';
DATA_FIM: 'data_fim';
DESTINO: 'destino';
COMPANHIA: 'companhia';
DIA: 'dia';
ATIVIDADE: 'atividade';
LOCAL: 'local';
HORARIO: 'horario';
DURACAO: 'duracao';

// Identificadores e Literais
STRING: '"' ( '\\' . | ~[\\"\r\n] )* '"';  
DIA_MES: [0-9][0-9]; 
ANO: [0-9][0-9][0-9][0-9];

TEMPO: [0-2][0-9] ':' [0-6][0-9];

// Símbolos
DELIM: ':';
TRACO: '-';
ABRECHAVE: '{';
FECHACHAVE: '}';
COMMA: ',';

// Espaços em branco e comentários
WS: [ \t\r\n]+ -> skip;
COMMENT: '//' .*? '\n' -> skip;
//Erros Léxicos
STRING_NAO_FECHADA   : '"' ( ~('\n'))*?;
SIMBOLO_NAO_ENCONTRADO: .;
/* -------------------- ESTRUTURA SINTÁTICA ------------------------- */
// Regra principal para a viagem
itinerario: 'viagem' STRING ABRECHAVE viagem_info hospedagem_info transporte_info atividades_info FECHACHAVE;

//Estrutura sintática para definir a data (verificação de dia e mês feito na parte semântica)
data: DIA_MES '/' DIA_MES '/' ANO; 

//Estrutura sintática para definição das informações da viagem
viagem_info
    : DATA_INICIO DELIM data
      DATA_FIM DELIM data
      DESTINO DELIM STRING
    ;
//Definição das informações de hospedagem
hospedagem_info
    : HOSPEDAGEM ABRECHAVE
        TIPO DELIM STRING
        NOME DELIM STRING
        CHECK_IN DELIM data
        CHECK_OUT DELIM data
      FECHACHAVE
    ;
//Definição das iformações de transporte
transporte_info
    : TRANSPORTE ABRECHAVE
        TIPO DELIM STRING
        COMPANHIA DELIM STRING
      FECHACHAVE
    ;
//Lista de atividades
atividades_info
    : ATIVIDADES ABRECHAVE atividade_list FECHACHAVE
    ;

atividade_list
    : (atividade_item)+
    ;

atividade_item
    : ABRECHAVE DIA DELIM data ATIVIDADE DELIM STRING LOCAL DELIM STRING DURACAO DELIM TEMPO FECHACHAVE
    ;
