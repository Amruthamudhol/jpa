
<html>
<head>
    <title>EventEase - Register</title>
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
            background-color: #f5f6ff;
        }

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
        .logo span {
            color: #9c27ff;
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
            background-color: #8e24aa;
        }

        main {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 50px 20px;
        }

        .register-container {
            width: 700px;
            background-color: white;
            padding: 35px 45px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
        }

        .register-container h1 {
            text-align: center;
            margin-bottom: 10px;
            color: #222;
        }

        .register-container h1 span {
            color: #9c27ff;
        }

        .subtitle {
            text-align: center;
            color: #666;
            margin-bottom: 30px;
        }

        .form-row {
            display: flex;
            gap: 20px;
            margin-bottom: 20px;
        }

        .form-group {
            flex: 1;
        }

        .form-group label {
            display: block;
            margin-bottom: 7px;
            font-weight: bold;
            color: #333;
        }

        .form-group input,
        .form-group select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        .form-group input:focus,
        .form-group select:focus {
            outline: none;
            border-color: #9c27ff;
        }

        .register-submit {
            width: 100%;
            padding: 13px;
            margin-top: 10px;
            border: none;
            border-radius: 6px;
            background-color: #8e24aa;
            color: white;
            font-size: 17px;
            font-weight: bold;
            cursor: pointer;
        }

        .register-submit:hover {
            background-color: #6a1b9a;
        }

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

<header>

    <!-- Logo -->
    <div class="logo">
        Event<span>Ease</span>
    </div>

    <!-- Navigation -->
    <nav>
        <a href="index.jsp">Home</a>
        <a href="register.jsp" class="register-btn">Register</a>
    </nav>

</header>


<main>
    <div class="register-container">
        <h1>Create Your <span>EventEase</span> Account</h1>
        <p class="subtitle">
            Fill in the details below to register
        </p>

        <form action="register" method="post">
            <!-- Row 1 -->
            <div class="form-row">

                <div class="form-group">
                    <label>Full Name</label>
                    <input type="text"  name="name"  placeholder="Enter your full name" required>
                </div>

                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" name="email" placeholder="Enter your email"  required>
                </div>
            </div>


            <!-- Row 2 -->
            <div class="form-row">

                <div class="form-group">
                    <label>Phone Number</label>
                    <input type="tel" name="phone"  placeholder="Enter your phone number"  required>
                </div>

                <div class="form-group">
                    <label>Date of Birth</label>
                    <input type="date"name="dob"  required>
                </div>

            </div>


            <!-- Row 3 -->
            <div class="form-row">

                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password"  placeholder="Create a password"  required>
                </div>

                <div class="form-group">
                    <label>Confirm Password</label>
                    <input type="password" name="confirmPassword"  placeholder="Confirm your password" required>
                </div>

            </div>


            <!-- Row 4 -->
            <div class="form-row">
                <div class="form-group">
                    <label>City</label>
                    <input type="text" name="city" placeholder="Enter your city" required>
                </div>

                <div class="form-group">
                    <label>Interested In</label>

                    <select name="eventType" required>
                        <option value="">Select event type</option>
                        <option value="Workshop">Workshop</option>
                        <option value="Conference">Conference</option>
                        <option value="Seminar">Seminar</option>
                        <option value="Concert">Concert</option>
                        <option value="Wedding">Wedding</option>
                        <option value="Birthday">Birthday</option>
                    </select>

                </div>

            </div>


            <!-- Submit -->
            <button type="submit" class="register-submit">
                Register Now
            </button>

        </form>

    </div>

</main>


<!-- ================= FOOTER ================= -->

<footer>
    <p>
        @ 2026 EventEase. All Rights Reserved.
    </p>

</footer>

</body>
</html>