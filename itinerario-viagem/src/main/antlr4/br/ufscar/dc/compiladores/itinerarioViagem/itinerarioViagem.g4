grammar itinerarioViagem;

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
//Erros
STRING_NAO_FECHADA   : '"' ( ~('\n'))*?;
SIMBOLO_NAO_ENCONTRADO: .;

// Regra principal para a viagem
itinerario: 'viagem' STRING ABRECHAVE viagem_info hospedagem_info transporte_info atividades_info FECHACHAVE;

data: DIA_MES '/' DIA_MES '/' ANO; 

viagem_info
    : DATA_INICIO DELIM data
      DATA_FIM DELIM data
      DESTINO DELIM STRING
    ;

hospedagem_info
    : HOSPEDAGEM ABRECHAVE
        TIPO DELIM STRING
        NOME DELIM STRING
        CHECK_IN DELIM data
        CHECK_OUT DELIM data
      FECHACHAVE
    ;

transporte_info
    : TRANSPORTE ABRECHAVE
        TIPO DELIM STRING
        COMPANHIA DELIM STRING
      FECHACHAVE
    ;

atividades_info
    : ATIVIDADES ABRECHAVE atividade_list FECHACHAVE
    ;

atividade_list
    : (atividade_item)+
    ;

atividade_item
    : ABRECHAVE DIA DELIM data ATIVIDADE DELIM STRING LOCAL DELIM STRING HORARIO DELIM TEMPO FECHACHAVE
    ;
