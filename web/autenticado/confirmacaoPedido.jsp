<body>
    <div id="wrapper">
        <jsp:include page="../WEB-INF/incluir/menu.jsp" />
        <div id="page-wrapper">
            <div class="container-fluid" id="rota">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-10">
                        <h1 class="page-header">
                            Rota <small>-</small>
                        </h1>
                    </div>
                </div>

                <div class="row" >
                    <style>
                        #mapa { width: 600px; height: 400px; }
                    </style>
                    <div class="col-lg-3 col-md-6" id="mapa">                      
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <p>Pedido Nº: <%=request.getParameter("codPedido")%></p>
                    </div>
                </div>
            </div>
            <button id="print" onclick="printContents('rota');" >Print</button>
            <div onclick="gmapPrint();">Print Button</div>
        </div>

    </div>
    <script src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script>
                var map;
                var directionsDisplay;
                var directionsService = new google.maps.DirectionsService();
                function printContent(el) {
                    var restorepage = $('body').html();                                        
                    var printcontent = $('#' + el).clone();
                    $('body').empty().html(printcontent);                                        
                    window.print();
                    $('body').html(restorepage);
                }
                function printContents(id)
{
    var contents = $("#"+id).html();

    if ($("#rota").length == 0)
    {
    var printDiv = null;
    printDiv = document.createElement('div');
    printDiv.setAttribute('id','printDiv');
    printDiv.setAttribute('class','printable');
    $(printDiv).appendTo('body');
    }

    $("#rota").html(contents);

    window.print();

    $("#rota").remove();


}
                function gmapPrint() {
    var content = window.document.getElementById("mapa"); // get you map details
    var newWindow = window.open(); // open a new window
    newWindow.document.write(content.innerHTML); // write the map into the new window
    newWindow.print(); // print the new window
}
                function sleepFor( sleepDuration ){
    var now = new Date().getTime();
    while(new Date().getTime() < now + sleepDuration){ /* do nothing */ } 
}
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

    <script type="text/javascript">
        //http://stackoverflow.com/questions/2255291/print-the-contents-of-a-div


    </script>
</body>

