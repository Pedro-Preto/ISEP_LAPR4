grammar FormChecker;

lprog:start+;

start : (allParameters  NEWLINE);

allParameters: parameterDate | parameterString | parameterInt | parameterBool | parameterPhoneNumber | parameterPostalCode | parameterName | parameterAddress | parameterOptionalDate | parameterOptionalBool |
parameterOptionalInt | parameterOptionalString | parameterOptionalAddress | parameterOptionalName | parameterOptionalPhoneNumber | parameterOptionalPostalCode;

parameterDate : TYPEDATE ' ' STRING ': ' DATE ;

parameterOptionalDate : TYPEOPTIONALDATE ' ' STRING ': ' optionalDate ;

parameterInt : TYPEINT ' ' STRING ': ' INT ;

parameterOptionalInt : TYPEOPTIONALINT ' ' STRING ': ' optionalInt ; 

parameterBool : TYPEBOOL ' ' STRING ': ' booleano ;

parameterOptionalBool : TYPEOPTIONALBOOL ' ' STRING ': ' optionalBool ; 

parameterString : TYPESTRING ' ' STRING ': ' stringPossibility  ;

parameterOptionalString : TYPEOPTIONALSTRING ' ' STRING ': ' optionalString  ; 

parameterAddress: TYPEADDRESS ' ' STRING ': 'addressPosibility;

parameterOptionalAddress: TYPEOPTIONALADDRESS ' ' STRING ': 'optionalAddress; 

parameterPhoneNumber : TYPEPHONENUMBER ' ' STRING ': ' PHONENUMBER ;

parameterOptionalPhoneNumber : TYPEOPTIONALPHONENUMBER ' ' STRING ': ' optionalPhoneNumber ; 

parameterPostalCode : TYPEPOSTALCODE ' ' STRING ': ' POSTALCODE ;

parameterOptionalPostalCode : TYPEOPTIONALPOSTALCODE ' ' STRING ': ' optionalPostalCode ; 

parameterName : TYPENAME ' ' STRING ': ' namePossibility ;

parameterOptionalName : TYPEOPTIONALNAME ' ' STRING ': ' optionalName ; 

namePossibility: ( NAME | NAME ' 'namePossibility)|;

addressPosibility: stringPossibility | stringPossibility ' 'addressPosibility;


stringPossibility: STRING | INT | NAME | booleano;

booleano : TRUE
| FALSE
;

optionalDate : | DATE;

optionalName : | namePossibility;

optionalAddress : | addressPosibility;

optionalPostalCode : | POSTALCODE;

optionalString : | stringPossibility;

optionalBool : | booleano;

optionalInt : | INT;

optionalPhoneNumber : | PHONENUMBER;

TYPEDATE: 'Date';
TYPEOPTIONALDATE:'OptionalDate';
TYPEINT: 'Integer';
TYPEOPTIONALINT: 'OptionalInteger';
TYPESTRING: 'String';
TYPEOPTIONALSTRING: 'OptionalString';
TYPEBOOL:'Bool';
TYPEOPTIONALBOOL:'OptionalBool';
TYPEPHONENUMBER:'PhoneNumber';
TYPEOPTIONALPHONENUMBER: 'OptionalPhoneNumber';
TYPEPOSTALCODE:'PostalCode';
TYPEOPTIONALPOSTALCODE:'OptionalPostalCode';
TYPENAME:'Name';
TYPEOPTIONALNAME: 'OptionalName';
TYPEADDRESS:'Address';
TYPEOPTIONALADDRESS:'OptionalAddress';

/*==========================*/

TRUE : 'true' | 'TRUE' ;
FALSE : 'false' | 'FALSE';
NAME : [A-Z][a-z]+;
PHONENUMBER : ( ('9'|'2') [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9] );
INT : [0-9]+;
STRING: [A-Za-z0-9]+;
DATE : ( ('0'?[1-9] | ('1'[0-9]) | ('2'[0-9]) | ('3'[0-1]) )'/'(('0'?[1-9]) | '1'[0-2])'/'([2-9][0-9][0-9][0-9] ));
POSTALCODE : ( [0-9][0-9][0-9][0-9]'-'[0-9][0-9][0-9] );
NEWLINE : ('\r'? '\n' | '\r' )+ | EOF ;
