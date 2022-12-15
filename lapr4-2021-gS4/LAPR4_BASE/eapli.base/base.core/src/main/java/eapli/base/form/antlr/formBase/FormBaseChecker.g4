grammar FormBaseChecker;

lprog:start+;

start : (joinedParameters  NEWLINE);

joinedParameters: parameterType ' 'STRING'//'parameterLabel':';

parameterType : TYPEDATE | TYPEINT  |TYPESTRING | TYPEBOOL |TYPENAME | TYPEADDRESS | TYPEPHONENUMBER | TYPEPOSTALCODE
              | TYPEOPTIONALDATE | TYPEOPTIONALINT |TYPEOPTIONALSTRING |TYPEOPTIONALBOOL | TYPEOPTIONALPHONENUMBER | TYPEOPTIONALPOSTALCODE | TYPENAME |TYPEOPTIONALADDRESS |;

parameterLabel : (stringPossibilities | stringPossibilities ' ' parameterLabel | stringPossibilities  parameterLabel);

stringPossibilities: STRING | '(' | ')' | '/' | '"';

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
STRING: [A-Za-z0-9]+;
NEWLINE : ('\r'? '\n' | '\r' )+ | EOF ;