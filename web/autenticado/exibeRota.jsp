<body>
    <div id="wrapper">
        <jsp:include page="../WEB-INF/incluir/menu.jsp" />
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-10">
                        <h1 class="page-header">
                            Rota <small>-</small>
                        </h1>
                    </div>
                </div>

                <div class="row">
                    <style>
                        #mapa { width: 600px; height: 400px; }
                    </style>
                    <div id="mapa"></div>   

                </div>
            </div>

        </div>
    </div>
    <script src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script>
        var map;
        var directionsDisplay;
        var directionsService = new google.maps.DirectionsService();

        function initialize() {
            directionsDisplay = new google.maps.DirectionsRenderer();
            var latlng = new google.maps.LatLng(-21.78313032, -46.56889522);
            var enderecoPartida = "-21.78313032, -46.56889522"
            var enderecoChegada = "-21.78313032, -46.55688301"
            //var enderecoPartida = "<%=request.getAttribute("rotaPartida")%>"
            //var enderecoChegada = "<%=request.getAttribute("rotaChegada")%>"

            var options = {
                zoom: 5,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

            var request = {
                origin: enderecoPartida,
                destination: enderecoChegada,
                travelMode: google.maps.TravelMode.DRIVING
            };

            map = new google.maps.Map(document.getElementById("mapa"), options);

            directionsService.route(request, function (result, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(result);
                }
            });

            directionsDisplay.setMap(map);
        }

        initialize();

    </script>
</body>

