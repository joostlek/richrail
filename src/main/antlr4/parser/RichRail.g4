grammar RichRail;

// Rules
command                 : newcommand | addcommand | getcommand | delcommand | remcommand;
newcommand              : newtraincommand | newwagoncommand | newlocomotivecommand;
newtraincommand         : 'new' 'train' ID                      # CommandNewTrain;
newwagoncommand         : 'new' 'wagon' ID ('numseats' NUMBER)? # CommandNewWagon;
newlocomotivecommand    : 'new' 'locomotive' ID                 # CommandNewLocomotive;
addcommand              : 'add' ID 'to' ID                      # CommandAdd;
getcommand              : 'getnumseats' type id=ID              # CommandGet;
delcommand              : 'delete' type ID                      # CommandDel;
remcommand              : 'remove' ID 'from' ID                 # CommandRem;
type                    : 'train' | 'wagon' | 'locomotive'      # Type;

// Tokens
ID          : ('a'..'z')('a'..'z'|'0'..'9')*;
NUMBER      : ('0'..'9')+;
WHITESPACE  : [ \t\r\n\u000C] -> skip;