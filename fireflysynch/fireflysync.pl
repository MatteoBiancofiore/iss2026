%====================================================================================
% fireflysync description   
%====================================================================================
dispatch( cellstate, cellstate(X,Y,COLOR) ).
event( syn, syn(FREQUENCY) ).
event( sonar_data, distance(D) ).
dispatch( stop_syn, stop_syn(0) ).
%====================================================================================
context(ctxfireflysynch, "localhost",  "TCP", "8040").
context(ctxgrid, "127.0.0.1",  "TCP", "8050").
 qactor( griddisplay, ctxgrid, "external").
  qactor( firefly1, ctxfireflysynch, "it.unibo.firefly1.Firefly1").
 static(firefly1).
  qactor( firefly2, ctxfireflysynch, "it.unibo.firefly2.Firefly2").
 static(firefly2).
  qactor( firefly3, ctxfireflysynch, "it.unibo.firefly3.Firefly3").
 static(firefly3).
  qactor( syncer, ctxfireflysynch, "it.unibo.syncer.Syncer").
 static(syncer).
  qactor( sonar, ctxfireflysynch, "it.unibo.sonar.Sonar").
 static(sonar).
