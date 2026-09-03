
<html>
<head>
    <title>EventEase</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        /* Header */
        header {
            height: 70px;
            background-color: #222;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 50px;
        }

        .logo {
            color: white;
            font-size: 28px;
            font-weight: bold;
        }

        nav {
            display: flex;
            gap: 15px;
        }

        nav a {
            text-decoration: none;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
        }

        nav a:hover {
            background-color: #444;
        }

        .register-btn {
            background-color: #007bff;
        }

        /* Main */
        main {
            flex: 1;
            text-align: center;
            padding: 100px 20px;
        }

        main h1 {
            font-size: 40px;
            margin-bottom: 20px;
        }

        main p {
            font-size: 18px;
            color: #555;
        }

        /* Footer */
        footer {
            height: 60px;
            background-color: #222;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>

<body>

<!-- Header -->
<header>

    <!-- Logo -->
    <div class="logo">
        EventEase
    </div>

    <!-- Navigation -->
    <nav>
        <a href="index.jsp">Home</a>
        <a href="register.jsp" class="register-btn">Register</a>
    </nav>

</header>


<main>
  <h1>Welcome to EventEase</h1>
    <p>
        Your one-stop platform for easy and seamless event registration.
    </p>

</main>

<!-- Footer -->
<footer>

    <p>  @2026 EventEase. All Rights Reserved.</p>

</footer>

</body>
</html>
