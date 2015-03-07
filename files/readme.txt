1.The ~x operator matches anything but x.

2.About CVS.g4 "file : hdr row+ ;", why use hdr? 
Because header rows are no different from regular rows; we simply interpret the column value as the column header name. 
Rather than using a row+ ANTLR fragment to match rows as well as the header row, we match it separately.
When building a real application based upon this grammar, we’d probably want to treat the header differently.
This way, we can get a handle on the first special row. 

3. Rules prefixed with fragment can be called only from other lexer rules; they are not tokens in their own right.

4.