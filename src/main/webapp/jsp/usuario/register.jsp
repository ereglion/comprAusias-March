<form id="loginForm" class="form-horizontal" method="post">
    <h1>Formulario de registro en el sistema</h1>    
    <div>
        <input type="hidden" name="class" value="usuario" />
    </div>
    <div>
        <input type="hidden" name="method" value="login" />
    </div>
    <div>
        <input type="hidden" name="phase" value="2" />
    </div>
    <div class="control-group">
        <label class="control-label" for="inputEmail">Usuario:</label>
        <div class="controls">
            <input type="text" id="text" autofocus="autofocus" placeholder="Nombre de usuario" name="login">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputPassword">Password:</label>
        <div class="controls">
            <input type="password" id="inputPassword" placeholder="Password" name="password">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputPassword">Nombre:</label>
        <div class="controls">
            <input type="nombre" id="inputNombre" placeholder="Nombre" name="nombre">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputPassword">Email:</label>
        <div class="controls">
            <input type="email" id="inputEmail" placeholder="Email" name="email">
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <!--
            <label class="checkbox"> <input type="checkbox">
                Remember me
            </label>
            -->
            <button type="submit" class="btn">Entrar</button>
        </div>
    </div>
</form>