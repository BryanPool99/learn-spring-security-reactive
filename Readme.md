JWT (JSON Web Tokens).

Importancia:
1) El usuario hace login una sola vez.
2) Si los datos son correctos, el servidor le entrega un "Pasaporte Digital" (el Token) firmado por ti.
3) En las siguientes peticiones, el usuario solo muestra el Token. Tu servidor lo valida sin ir a la base de datos, solo verificando tu firma digital.

Pasos a seguir:
1) La Dependencia: jjwt-api,jjwt-impl y jjwt-jackson
2) El Proveedor de JWT (JwtProvider)-> generar token y validarlo