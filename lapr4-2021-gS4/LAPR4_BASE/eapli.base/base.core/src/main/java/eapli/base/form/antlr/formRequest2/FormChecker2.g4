grammar FormChecker2;

lprog:start+ EOF;

start : (allParameters  NEWLINE);

allParameters: parameterDate | parameterString | parameterInt | parameterBool | parameterPhoneNumber | parameterPostalCode | parameterName | parameterAddress | error;

parameterDate : TYPEDATE ' ' STRING ': ' ( | STRING FSLASH STRING FSLASH STRING) ;

parameterInt : TYPEINT ' ' STRING ': ' ( | STRING );

parameterBool : TYPEBOOL ' ' STRING ': ' ( | STRING) ;

parameterString : TYPESTRING ' ' STRING ': '  ( | stringPhrase)  ;

parameterAddress: TYPEADDRESS ' ' STRING ': '( | stringPhrase);

parameterPhoneNumber : TYPEPHONENUMBER ' ' STRING ': ' ( | STRING) ;

parameterPostalCode : TYPEPOSTALCODE ' ' STRING ': ' ( | STRING DASH STRING) ;

parameterName : TYPENAME ' ' STRING ': ' ( | stringPhrase) ;

stringPhrase: STRING | STRING ' 'stringPhrase;

error: . ;

TYPEDATE: 'Date' | 'OptionalDate';
TYPEINT: 'Integer' | 'OptionalInteger';
TYPESTRING: 'String' | 'OptionalString';
TYPEBOOL:'Bool' | 'OptionalBool';
TYPEPHONENUMBER:'PhoneNumber' | 'OptionalPhoneNumber';
TYPEPOSTALCODE:'PostalCode' | 'OptionalPostalCode';
TYPENAME:'Name' | 'OptionalName';
TYPEADDRESS:'Address' | 'OptionalAddress' ;

/*==========================*/

DASH: '-';
FSLASH: '/';
STRING: [A-Za-z0-9]+;
NEWLINE : ('\r'? '\n' | '\r' )+;