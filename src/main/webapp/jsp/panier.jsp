<!DOCTYPE html>
<html lang="en">
<head>
    <title>Votre Panier - FoodMart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/vendor.css">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    <!-- Header -->
    <header>
        <div class="container-fluid">
            <div class="row py-3 border-bottom">
                <div class="col-sm-4 col-lg-3 text-center text-sm-start">
                    <div class="main-logo">
                        <a href="index.html">
                            <img src="images/logo.png" alt="logo" class="img-fluid">
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <main class="container my-5">
        <h2 class="mb-4">Votre Panier</h2>

        <div class="row">
            <div class="col-md-8">
                <ul class="list-group mb-3">
                    <!-- Item 1 -->
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <div class="d-flex align-items-center">
                            <img src="images/thumb-bananas.png" alt="Growers Cider" class="img-fluid" style="width: 50px; height: auto; margin-right: 15px; border: 1px solid black;">
                            <div>
                                <h6 class="my-0">Growers Cider</h6>
                                <small class="text-muted">Boisson rafraichissante</small>
                            </div>
                        </div>
                        <span class="text-muted">$12</span>
                    </li>

                    <!-- Item 2 -->
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <div class="d-flex align-items-center">
                            <img src="images/thumb-bananas.png" alt="Fresh Grapes" class="img-fluid" style="width: 50px; height: auto; margin-right: 15px; border: 1px solid black;">
                            <div>
                                <h6 class="my-0">Fresh Grapes</h6>
                                <small class="text-muted">Fruits bio et frais</small>
                            </div>
                        </div>
                        <span class="text-muted">$8</span>
                    </li>

                    <!-- Item 3 -->
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <div class="d-flex align-items-center">
                            <img src="images/thumb-bananas.png" alt="Heinz Tomato Ketchup" class="img-fluid" style="width: 50px; height: auto; margin-right: 15px; border: 1px solid black;">
                            <div>
                                <h6 class="my-0">Heinz Tomato Ketchup</h6>
                                <small class="text-muted">Sauce tomate classique</small>
                            </div>
                        </div>
                        <span class="text-muted">$5</span>
                    </li>

                    <!-- Total -->
                    <li class="list-group-item d-flex justify-content-between">
                        <strong>Total (USD)</strong>
                        <strong>$25</strong>
                    </li>
                </ul>

                <!-- Checkout Button -->
                <button class="btn btn-primary btn-lg w-100">Passer a  la caisse</button>
            </div>
        </div>
    </main>

    <!-- Footer -->
    <footer class="text-center py-3">
        <p class="text-muted"> @ 2025 FoodMart - Tous droits reserves.</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
