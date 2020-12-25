# Turnero

Turnero con conexión socket tcp/ip creado en java escucha en el puerto: 9876

## comandos disponibles:

- initPlayview : abre en segunda pantalla la lista de turno para monitor externo al público.
- disposePlayView: cierra pantalla externa.
- addTurn: añade un nuevo turno.
- nextTurn: avanza al próximo turno y lo muestra.
- exit: apagar el servidor socket.

El programa funciona remotamente mediante una conexion tcp/ip en el puerto 9876 la dirección del
servidor depende del pc que se ejecute la aplicación servidor. y solo hace falta enviar los comandos al servidor.
